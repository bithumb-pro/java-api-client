package cn.bithumb.pro.api.example;

import cn.bithumb.pro.api.BithumbProApiClientFactory;
import cn.bithumb.pro.api.BithumbProApiRestClient;
import cn.bithumb.pro.api.BithumbProApiWebSocketClient;
import cn.bithumb.pro.api.JsonUtil;
import cn.bithumb.pro.api.constants.TopicEnum;
import cn.bithumb.pro.api.model.BaseResponse;
import cn.bithumb.pro.api.model.BaseWebSocketResponse;
import cn.bithumb.pro.api.model.market.OrderBook;
import cn.bithumb.pro.api.service.ResponseListener;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class BuildOrderBook {
    private static final String ask = "ASKS";
    private static final String bid = "BIDS";
    private Long restVersion = 0L;
    private static LinkedBlockingQueue<OrderBook> orderBookQueue = new LinkedBlockingQueue<>();
    private static Map<String, NavigableMap<BigDecimal, BigDecimal>> depthCache = new HashMap<>();

    private void doSubscribeWsWithOrderBook(String symbol) {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance();
        BithumbProApiWebSocketClient webSocketClient = factory.newWebSocketClient();
        String topic = String.format("%s:%s", TopicEnum.ORDERBOOK.name(), symbol);
        webSocketClient.subscribe(Collections.singletonList(topic));
        webSocketClient.onOrderBook(TopicEnum.ORDERBOOK.name(), (ResponseListener<BaseWebSocketResponse<OrderBook>>) msg -> {
            OrderBook orderBook = msg.getData();
            if(!symbol.equals(orderBook.getSymbol())) {
                return;
            }
            orderBookQueue.add(orderBook);
        });
    }

    private void doRequestRestAndBuildInitDepthCache(String symbol) {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance();
        BithumbProApiRestClient restClient = factory.newRestClient();
        BaseResponse<OrderBook> restInfo = restClient.orderBook(symbol);
        if (null == restInfo) {
            return;
        }
        OrderBook orderBook = restInfo.getData();
        NavigableMap<BigDecimal, BigDecimal> bidsMap = new TreeMap<>(Comparator.reverseOrder());
        orderBook.getB().forEach(i -> bidsMap.put(new BigDecimal(i[0]), new BigDecimal(i[1])));
        NavigableMap<BigDecimal, BigDecimal> asksMap = new TreeMap<>(BigDecimal::compareTo);
        orderBook.getS().forEach(i -> asksMap.put(new BigDecimal(i[0]), new BigDecimal(i[1])));
        depthCache.put(ask, asksMap);
        depthCache.put(bid, bidsMap);
        restVersion = Long.valueOf(orderBook.getVer());
        System.out.println("FIRST VERSION: " + restVersion + " ORDERBOOK: " + JsonUtil.objToJson(depthCache));
    }

    private void handleData() {
        while (true) {
            try {
                OrderBook partOrderBook = orderBookQueue.take();
                Long tempVer = Long.valueOf(partOrderBook.getVer());
                if (tempVer <= restVersion) {
                    continue;
                }
                List<String[]> asks = partOrderBook.getS();
                NavigableMap<BigDecimal, BigDecimal> asksMap = depthCache.get(ask);
                asks.forEach(i -> {
                    if ("0".equals(i[1])) {
                        asksMap.remove(new BigDecimal(i[0]));
                    } else {
                        asksMap.put(new BigDecimal(i[0]), new BigDecimal(i[1]));
                    }
                });
                List<String[]> bids = partOrderBook.getB();
                NavigableMap<BigDecimal, BigDecimal> bidsMap = depthCache.get(bid);
                bids.forEach(i -> {
                    if ("0".equals(i[1])) {
                        bidsMap.remove(new BigDecimal(i[0]));
                    } else {
                        bidsMap.put(new BigDecimal(i[0]), new BigDecimal(i[1]));
                    }
                });
                System.out.println("VERSION: " + tempVer +" ORDERBOOK : " + JsonUtil.objToJson(depthCache));
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void buildOrderBook(String symbol) {
        //first subscribe orderbook
        doSubscribeWsWithOrderBook(symbol);
        //rest for full orderbook
        doRequestRestAndBuildInitDepthCache(symbol);
        //start handle orderbook temp
        handleData();
    }

    public static void main(String[] args) {
        BuildOrderBook buildOrderBook = new BuildOrderBook();
        String symbol = "BTC-USDT";
        buildOrderBook.buildOrderBook(symbol);
    }
}
