package cn.bithumb.pro.api.test;

import cn.bithumb.pro.api.BithumbProApiClientFactory;
import cn.bithumb.pro.api.BithumbProApiWebSocketClient;
import cn.bithumb.pro.api.constants.TopicEnum;

import java.util.Collections;

public class TestWebSocket {

    public static void main(String[] args) {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance();
        BithumbProApiWebSocketClient webSocketClient = factory.newWebSocketClient();
        String topic = TopicEnum.CONTRACT_PRICE.name();
        webSocketClient.subscribe(Collections.singletonList(topic));
    }
}
