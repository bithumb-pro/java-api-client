package cn.bithumb.pro.api;

import cn.bithumb.pro.api.service.ResponseListener;

import java.util.List;

public interface BithumbProApiWebSocketClient {

    void success();

    void subscribe(List<String> topics);

    void unSubscribe(List<String> topics);

    void ping();

    void authKey(String apiKey, Long timestamp, String signature);

    <T> void onOrderBook(String topic, ResponseListener<T> responseListener);

    <T> void onTrades(String topic, ResponseListener<T> responseListener);

    void onPrice(String topic, ResponseListener responseListener);

}
