package cn.bithumb.pro.api.security;

import cn.bithumb.pro.api.constants.BithumbProApiConstants;
import okhttp3.*;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Objects;

import static cn.bithumb.pro.api.constants.BithumbProApiConstants.API_VERSION;

/**
 * A request interceptor that injects the API Key Header into requests, and signs messages, whenever required.
 */
public class AuthenticationInterceptor implements Interceptor {

    private final String apiKey;

    private final String secret;

    public AuthenticationInterceptor(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();

        boolean needAuth = original.header(BithumbProApiConstants.SECURITY_SIGN_TAG) != null;
        newRequestBuilder.removeHeader(BithumbProApiConstants.SECURITY_SIGN_TAG);
        HttpUrl.Builder builder = original.url().newBuilder();
        builder.
                addQueryParameter("version", API_VERSION);
        if (needAuth) {
            String payload = original.url().query();
            if (!StringUtils.isEmpty(payload)) {
                String signature = HmacSHA256Signer.sign(payload, secret);
                builder.
                        addQueryParameter("signature", signature).
                        addQueryParameter("apiKey", apiKey);
//                HttpUrl signedUrl = original.url().newBuilder().
//                        addQueryParameter("signature", signature).
//                        addQueryParameter("apiKey", apiKey).
//                        build();
//                newRequestBuilder.url(signedUrl);
            }
        }
        newRequestBuilder.url(builder.build());
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }

    /**
     * Extracts the request body into a String.
     *
     * @return request body as a string
     */
    @SuppressWarnings("unused")
    private static String bodyToString(RequestBody request) {
        try (final Buffer buffer = new Buffer()) {
            final RequestBody copy = request;
            if (copy != null) {
                copy.writeTo(buffer);
            } else {
                return "";
            }
            return buffer.readUtf8();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AuthenticationInterceptor that = (AuthenticationInterceptor) o;
        return Objects.equals(apiKey, that.apiKey) &&
                Objects.equals(secret, that.secret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, secret);
    }
}