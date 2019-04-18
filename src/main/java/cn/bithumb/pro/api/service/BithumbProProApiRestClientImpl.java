package cn.bithumb.pro.api.service;

import cn.bithumb.pro.api.BithumbProApiRestClient;
import cn.bithumb.pro.api.model.BaseResponse;
import cn.bithumb.pro.api.model.Config;
import cn.bithumb.pro.api.model.market.*;

import java.util.List;

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
    public BaseResponse<Config> spotConfig() {
        return BithumbProApiCore.executeSync(bithumbProApiService.config());
    }
}
