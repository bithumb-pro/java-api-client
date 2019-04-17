package cn.bithumb.pro.api;

import cn.bithumb.pro.api.service.BithumbProApiCore;
import cn.bithumb.pro.api.service.BithumbProProApiRestClientImpl;
import cn.bithumb.pro.api.service.BithumbProProApiWebSocketClientImpl;

public class BithumbProApiClientFactory {

    private String apiKey;
    private String secretKey;

    public BithumbProApiClientFactory(String apiKey, String secretKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    public static BithumbProApiClientFactory newInstance(String apiKey, String secretKey) {
        return new BithumbProApiClientFactory(apiKey, secretKey);
    }

    public static BithumbProApiClientFactory newInstance() {
        return new BithumbProApiClientFactory(null, null);
    }

    public BithumbProApiWebSocketClient newWebSocketClient() {
        return new BithumbProProApiWebSocketClientImpl(BithumbProApiCore.getClient());
    }

    public BithumbProApiRestClient newRestClient() {
        return new BithumbProProApiRestClientImpl(null, null);
    }
}
