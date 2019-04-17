package cn.bithumb.pro.api.test;

import cn.bithumb.pro.api.BithumbProApiClientFactory;
import cn.bithumb.pro.api.BithumbProApiRestClient;
import cn.bithumb.pro.api.BithumbProApiWebSocketClient;
import cn.bithumb.pro.api.JsonUtil;
import cn.bithumb.pro.api.constants.TopicEnum;
import cn.bithumb.pro.api.model.market.BaseResponse;
import cn.bithumb.pro.api.model.market.BaseWebSocketResponse1;
import cn.bithumb.pro.api.model.market.Trade;
import cn.bithumb.pro.api.service.ResponseListener;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class TradesTest {

    private final static int capacity = 100;
    private final static Queue<Trade> tradesQueue = new LinkedBlockingQueue<>(capacity);
    private final static LinkedBlockingQueue<Trade> wsTradesQueue = new LinkedBlockingQueue<>();
    private Long rest_version;

    private void buildTrades(String symbol) {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance();
        BithumbProApiWebSocketClient webSocketClient = factory.newWebSocketClient();
        String topic = String.format("%s:%s", TopicEnum.TRADE, symbol);
        webSocketClient.subscribe(Collections.singletonList(topic));
        webSocketClient.onTrades(TopicEnum.TRADE.name(), (ResponseListener<BaseWebSocketResponse1<Trade>>) msg -> {
            List<Trade> trades = msg.getData();
            trades = trades.stream().filter(Objects::nonNull).filter(i -> symbol.equals(i.getSymbol())).collect(Collectors.toList());
            wsTradesQueue.addAll(trades);
        });
    }

    private void doRestTrades(String symbol) {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance();
        BithumbProApiRestClient restClient = factory.newRestClient();
        BaseResponse<List<Trade>> restTrades = restClient.trades(symbol);
        List<Trade> trades = restTrades.getData();
        rest_version = Long.valueOf(trades.get(0).getVer());
        trades = trades.subList(0, capacity);
        Collections.reverse(trades);
        tradesQueue.addAll(trades);
        System.out.println("FIRST TRADES: " + JsonUtil.objToJson(trades));
    }

    private void handData() {
        while (true) {
            try {
                Trade trade = wsTradesQueue.take();
                Long version = Long.valueOf(trade.getVer());
                if (version <= rest_version) {
                    continue;
                }
                if (tradesQueue.size() >= capacity) {
                    tradesQueue.remove();
                }
                tradesQueue.add(trade);
                System.out.println("TRADES: " + JsonUtil.objToJson(tradesQueue));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TradesTest tradesTest = new TradesTest();
        String symbol = "BTC-USDT";
        tradesTest.buildTrades(symbol);
        tradesTest.doRestTrades(symbol);
        tradesTest.handData();
    }

}
