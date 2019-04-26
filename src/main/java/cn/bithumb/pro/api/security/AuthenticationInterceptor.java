package cn.bithumb.pro.api.security;

import cn.bithumb.pro.api.JsonUtil;
import cn.bithumb.pro.api.constants.BithumbProApiConstants;
import okhttp3.*;
import okio.Buffer;

import java.io.IOException;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

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
        if (needAuth) {
            HttpUrl url = original.url();
            Set<String> parameterNames = url.queryParameterNames();
            TreeMap<String, Object> params = new TreeMap<>();
            parameterNames.forEach(i -> params.put(i, url.queryParameter(i)));
            params.put("version", API_VERSION);
            params.put("apiKey", apiKey);
            String signature = HmacSHA256Signer.sign(params, secret);
            params.put("signature", signature);
            RequestBody body = RequestBody.create(MediaType.parse(BithumbProApiConstants.MEDIA_TYPE), JsonUtil.objToJson(params));
            newRequestBuilder.url(url).method(original.method(), body);
        } else {
            builder.
                    addQueryParameter("version", API_VERSION);
            newRequestBuilder.url(builder.build());
        }
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