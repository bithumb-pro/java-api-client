package cn.bithumb.pro.api.example;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

import cn.bithumb.pro.api.BithumbProApiClientFactory;
import cn.bithumb.pro.api.BithumbProApiRestClient;
import cn.bithumb.pro.api.BithumbProApiWebSocketClient;
import cn.bithumb.pro.api.JsonUtil;
import cn.bithumb.pro.api.constants.TopicEnum;
import cn.bithumb.pro.api.model.BaseResponse;
import cn.bithumb.pro.api.model.BaseWebSocketResponse;
import cn.bithumb.pro.api.model.market.Ticker;
import cn.bithumb.pro.api.model.market.Trade;
import cn.bithumb.pro.api.service.ResponseListener;

/**
 * 
 * @author lichen@oneroot.exchange
 *
 * 2019年5月30日
 *
 */
public class BuildTicker {

    private final static int capacity = 100;
    private final static Queue<Ticker> tickerQueue = new LinkedBlockingQueue<>(capacity);
    private final static LinkedBlockingQueue<Ticker> wsTickerQueue = new LinkedBlockingQueue<>();
    private Long rest_version;
    
    private void buildTickers(String symbol) {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance();
        BithumbProApiWebSocketClient webSocketClient = factory.newWebSocketClient();
        String topic = String.format("%s:%s", TopicEnum.TICKER, symbol);
        webSocketClient.subscribe(Collections.singletonList(topic));
        webSocketClient.onTrades(TopicEnum.TICKER.name(), (ResponseListener<BaseWebSocketResponse<List<Ticker>>>) msg -> {
            List<Ticker> tickers = msg.getData();
            tickers = tickers.stream().filter(Objects::nonNull).filter(i -> symbol.equals(i.getS())).collect(Collectors.toList());
            wsTickerQueue.addAll(tickers);
        });
    }
    
    private void doRestTickers(String symbol) {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance();
        BithumbProApiRestClient restClient = factory.newRestClient();
        BaseResponse<List<Ticker>> restTicker = restClient.ticker(symbol);
        List<Ticker> tickers = restTicker.getData();
        if (tickers != null && tickers.size()>0) {
			rest_version = Long.valueOf(tickers.get(0).getVer());
			tickers = tickers.subList(0, capacity);
			Collections.reverse(tickers);
			tickerQueue.addAll(tickers);
		}
        System.out.println("FIRST TRADES: " + JsonUtil.objToJson(tickers));
    }
    
    private void handData() {
        while (true) {
            try {
                Ticker ticker = wsTickerQueue.take();
                Long version = Long.valueOf(ticker.getVer());
                if (version <= rest_version) {
                    continue;
                }
                if (tickerQueue.size() >= capacity) {
                	tickerQueue.remove();
                }
                tickerQueue.add(ticker);
                System.out.println("TRADES: " + JsonUtil.objToJson(tickerQueue));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
    	BuildTicker buildTicker = new BuildTicker();
        String symbol = "BTC-USDT";
        buildTicker.buildTickers(symbol);
        buildTicker.doRestTickers(symbol);
        buildTicker.handData();
    }
}
