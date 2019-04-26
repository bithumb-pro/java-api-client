package cn.bithumb.pro.api.security;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Map;
import java.util.TreeMap;

/**
 * Utility class to sign messages using HMAC-SHA256.
 */
public class HmacSHA256Signer {

    /**
     * Sign the given message using the given secret.
     *
     * @param params    message to sign
     * @param secretKey secret key
     * @return a signed message
     */
    public static String sign(Map<String, Object> params, String secretKey) {
        TreeMap<String, Object> treeMap = new TreeMap<>();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            String key = param.getKey();
            Object value = param.getValue();
            treeMap.put(key, value);
        }
        StringBuilder sb = new StringBuilder();
        treeMap.forEach((key, value) -> sb.append(key).append("=").append(value).append("&"));
        String objToJson = sb.toString().substring(0, sb.length() - 1);
        return sign(objToJson, secretKey);
    }

    private static String sign(String message, String secretKey) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            return byteArrayToHexString(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }

}
