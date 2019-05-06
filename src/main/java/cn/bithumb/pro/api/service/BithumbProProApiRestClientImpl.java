package cn.bithumb.pro.api.service;

import cn.bithumb.pro.api.BithumbProApiRestClient;
import cn.bithumb.pro.api.model.BaseResponse;
import cn.bithumb.pro.api.model.Config;
import cn.bithumb.pro.api.model.NewOrder;
import cn.bithumb.pro.api.model.OrderQuery;
import cn.bithumb.pro.api.model.account.Asset;
import cn.bithumb.pro.api.model.account.MyTrades;
import cn.bithumb.pro.api.model.market.Kline;
import cn.bithumb.pro.api.model.market.OrderBook;
import cn.bithumb.pro.api.model.market.Ticker;
import cn.bithumb.pro.api.model.market.Trade;

import java.util.List;
import java.util.Map;

public class BithumbProProApiRestClientImpl implements BithumbProApiRestClient {

    private final BithumbProApiService bithumbProApiService;

    public BithumbProProApiRestClientImpl(String apiKey, String secret) {
        bithumbProApiService = BithumbProApiCore.createService(BithumbProApiService.class, apiKey, secret);
    }

    @Override
    public BaseResponse<List<Ticker>> ticker(String symbol) {
        return BithumbProApiCore.executeSync(bithumbProApiService.ticker(symbol));
    }

    @Override
    public BaseResponse<OrderBook> orderBook(String symbol) {
        return BithumbProApiCore.executeSync(bithumbProApiService.orderBook(symbol));
    }

    @Override
    public BaseResponse<List<Trade>> trades(String symbol) {
        return BithumbProApiCore.executeSync(bithumbProApiService.trades(symbol));
    }

    @Override
    public BaseResponse<List<Kline>> kline(String symbol, String type, Long startTime, Long endTime) {
        return BithumbProApiCore.executeSync(bithumbProApiService.kline(symbol, type, startTime, endTime));
    }

    @Override
    public BaseResponse<Config> spotConfig() {
        return BithumbProApiCore.executeSync(bithumbProApiService.config());
    }

    @Override
    public BaseResponse<Map<String, Object>> createOrder(NewOrder newOrder) {
        return BithumbProApiCore.executeSync(bithumbProApiService.newOrder(newOrder.getSymbol(), newOrder.getType(),
                newOrder.getSide(), newOrder.getPrice(),
                newOrder.getQuantity(), newOrder.getTimestamp(), newOrder.getMsgNo()));
    }

    @Override
    public BaseResponse<Map<String, Object>> cancelOrder(String orderId, String coinType, String marketType) {
        return BithumbProApiCore.executeSync(bithumbProApiService.cancelOrder(coinType, marketType, orderId));
    }

    @Override
    public BaseResponse<List<Asset>> assets(String coinType, String assetType) {
        return BithumbProApiCore.executeSync(bithumbProApiService.assets(coinType, assetType));
    }

    @Override
    public BaseResponse<Map<String, Object>> orderDetail(OrderQuery orderQuery) {
        return BithumbProApiCore.executeSync(bithumbProApiService.orderDetail(orderQuery.getCoinType(), orderQuery.getMarketType(),
                orderQuery.getOrderId(), orderQuery.getPage(), orderQuery.getCount()));
    }

    @Override
    public BaseResponse<Map<String, Object>> orders(OrderQuery orderQuery) {
        return BithumbProApiCore.executeSync(bithumbProApiService.orderList(orderQuery.getCoinType(), orderQuery.getMarketType(),
                orderQuery.getSide(), orderQuery.getStatus(), orderQuery.getQueryRange(), orderQuery.getPage(), orderQuery.getCount()));
    }

    @Override
    public BaseResponse<Map<String, Object>> openOrders(OrderQuery orderQuery) {
        return BithumbProApiCore.executeSync(bithumbProApiService.openOrders(orderQuery.getSymbol(), orderQuery.getPage(), orderQuery.getCount()));
    }

    @Override
    public BaseResponse<Map<String, Object>> singleOrder(OrderQuery orderQuery) {
        return BithumbProApiCore.executeSync(bithumbProApiService.singleOrder(orderQuery.getCoinType(), orderQuery.getMarketType(),
                orderQuery.getOrderId()));
    }

    @Override
    public BaseResponse<List<MyTrades>> myTrades(String symbol, Long startTime, Integer limit) {
        return BithumbProApiCore.executeSync(bithumbProApiService.myTrades(symbol, startTime, limit));
    }

}
