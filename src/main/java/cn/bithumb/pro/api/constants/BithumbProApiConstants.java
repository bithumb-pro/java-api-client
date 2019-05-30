package cn.bithumb.pro.api.constants;

public interface BithumbProApiConstants {

    String WS_API_BASE_URL = "wss://global-api.bithumb.pro/message/realtime";
    String REST_API_BASE_URL = "https://global-openapi.bithumb.pro";

//    String WS_API_BASE_URL = "ws://10.0.152.13:8081/message/realtime";
//    String REST_API_BASE_URL = "http://10.0.152.13:8081";

    String SECURITY_SIGN_TAG = "SIGNATURE";
    String SECURITY_SIGN_TAG_HEADER = SECURITY_SIGN_TAG + ": #";

    String MEDIA_TYPE = "application/json; charset=utf-8";

    String API_VERSION = "v1.0.0";

}
