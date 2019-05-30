package cn.bithumb.pro.api.service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.core.type.TypeReference;

import cn.bithumb.pro.api.BithumbProApiWebSocketClient;
import cn.bithumb.pro.api.JsonUtil;
import cn.bithumb.pro.api.constants.CodeEnum;
import cn.bithumb.pro.api.constants.TopicEnum;
import cn.bithumb.pro.api.model.BaseWebSocketMsg;
import cn.bithumb.pro.api.model.BaseWebSocketResponse;
import cn.bithumb.pro.api.model.market.OrderBook;
import cn.bithumb.pro.api.model.market.Ticker;
import cn.bithumb.pro.api.model.market.Trade;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class BithumbProApiListener extends WebSocketListener {

    private BithumbProApiWebSocketClient bithumbProApiWebSocketClient;

    public BithumbProApiListener(BithumbProApiWebSocketClient bithumbProApiWebSocketClient) {
        this.bithumbProApiWebSocketClient = bithumbProApiWebSocketClient;
    }

    private final static ConcurrentHashMap<String, ResponseListener> responseMap = new ConcurrentHashMap<>();

    public void onOpen(WebSocket webSocket, Response response) {
        System.out.println(response.toString());
    }

    public void onMessage(WebSocket webSocket, String text) {
        //handle msg
//        System.out.println(String.valueOf(System.currentTimeMillis()) + ":" + text);
        BaseWebSocketMsg baseWebSocketMsg = JsonUtil.jsonToObj(text, BaseWebSocketMsg.class);
        String topic = baseWebSocketMsg.getTopic();
        String code = baseWebSocketMsg.getCode();
        if (CodeEnum.CONNECTED.getCode().equals(code)) {
            bithumbProApiWebSocketClient.success();
        }
        ResponseListener responseListener;
        if (null == topic || null == (responseListener = responseMap.get(topic))) {
            return;
        }
        if (TopicEnum.TRADE.name().equals(topic)) {
            if (CodeEnum.INIT_MSG.getCode().equals(code)) {
                BaseWebSocketResponse<List<Trade>> response = JsonUtil.jsonToObj(text, new TypeReference<BaseWebSocketResponse<List<Trade>>>() {
                });
                responseListener.onResponse(response);
            }
            if (CodeEnum.NORMAL_MSG.getCode().equals(code)) {
                BaseWebSocketResponse<Trade> response = JsonUtil.jsonToObj(text, new TypeReference<BaseWebSocketResponse<Trade>>() {
                });
                BaseWebSocketResponse<List<Trade>> response1 = new BaseWebSocketResponse<>();
                response1.setMsg(response.getMsg());
                response1.setTimestamp(response.getTimestamp());
                response1.setCode(response.getCode());
                response1.setTopic(response.getTopic());
                response1.setData(Collections.singletonList(response.getData()));
                responseListener.onResponse(response1);
            }
            return;
        }
        if (TopicEnum.ORDERBOOK.name().equals(topic)) {
            BaseWebSocketResponse<OrderBook> response = JsonUtil.jsonToObj(text, new TypeReference<BaseWebSocketResponse<OrderBook>>() {
            });
            responseListener.onResponse(response);
            return;
        }
        //订阅ticker
        if (TopicEnum.TICKER.name().equals(topic)) {
            BaseWebSocketResponse<Ticker> response = JsonUtil.jsonToObj(text, new TypeReference<BaseWebSocketResponse<Ticker>>() {
            });
            responseListener.onResponse(response);
            return;
        }
    }

    public void onMessage(WebSocket webSocket, ByteString bytes) {
    }

    public void onClosing(WebSocket webSocket, int code, String reason) {
        System.out.println(code);
    }

    public void onClosed(WebSocket webSocket, int code, String reason) {
        System.out.println(code);
        System.out.println(reason);
    }

    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        System.out.println(t.getMessage());
    }

    public <T> void addListener(String topic, ResponseListener<T> responseListener) {
        responseMap.putIfAbsent(topic, responseListener);
    }

}
