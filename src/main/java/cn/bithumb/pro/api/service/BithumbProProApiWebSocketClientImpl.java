package cn.bithumb.pro.api.service;

import cn.bithumb.pro.api.BithumbProApiWebSocketClient;
import cn.bithumb.pro.api.JsonUtil;
import cn.bithumb.pro.api.constants.BithumbProApiConstants;
import cn.bithumb.pro.api.constants.CmdEnum;
import cn.bithumb.pro.api.model.Cmd;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BithumbProProApiWebSocketClientImpl implements BithumbProApiWebSocketClient, Closeable {

    private final OkHttpClient client;
    private WebSocket webSocket;

    private final BithumbProApiListener listener = new BithumbProApiListener(this);

    public BithumbProProApiWebSocketClientImpl(OkHttpClient client) {
        this.client = client;
        createNewWebSocket();
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(this::ping, 5, 30, TimeUnit.SECONDS);
    }

    @Override
    public void close() {
    }

    @Override
    public void subscribe(List<String> topics) {
        if (null == topics || topics.size() == 0) {
            return;
        }
        String msg = handleCmd(CmdEnum.subscribe.name(), topics);
        webSocket.send(msg);
    }

    @Override
    public void unSubscribe(List<String> topics) {
        if (null == topics || topics.size() == 0) {
            return;
        }
        String msg = handleCmd(CmdEnum.unSubscribe.name(), topics);
        webSocket.send(msg);
    }

    @Override
    public void ping() {
        String msg = handleCmd(CmdEnum.ping.name(), null);
        webSocket.send(msg);
    }

    @Override
    public void authKey(String apiKey, Long timestamp, String signature) {
        List<Object> args = new ArrayList<>();
        args.add(apiKey);
        args.add(String.valueOf(timestamp));
        args.add(signature);
        String msg = handleCmd(CmdEnum.authKey.name(), args);
        webSocket.send(msg);
    }

    @Override
    public <T> void onOrderBook(String topic, ResponseListener<T> responseListener) {
        listener.addListener(topic, responseListener);
    }

    @Override
    public <T> void onTrades(String topic, ResponseListener<T> responseListener) {
        listener.addListener(topic, responseListener);
    }

    @Override
    public void onPrice(String topic, ResponseListener responseListener) {
        listener.addListener(topic, responseListener);
    }

    private String handleCmd(String cmdString, List<?> args) {
        Cmd cmd = new Cmd();
        if (null != args && args.size() > 0) {
            cmd.setArgs(args);
        }
        cmd.setCmd(cmdString);
        return JsonUtil.objToJson(cmd);
    }

    public void success() {
        synchronized (listener) {
            listener.notifyAll();
        }
    }

    private Closeable createNewWebSocket() {
        Request request = new Request.Builder().url(BithumbProApiConstants.WS_API_BASE_URL).build();
        final WebSocket webSocket = client.newWebSocket(request, listener);
        synchronized (listener) {
            try {
                listener.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.webSocket = webSocket;
        return () -> {
            final int code = 1000;
            listener.onClosing(webSocket, code, null);
            webSocket.close(code, null);
            listener.onClosed(webSocket, code, null);
        };
    }

	@Override
	public <T> void onTicker(String topic, ResponseListener<T> responseListener) {
		listener.addListener(topic, responseListener);
	}
}
