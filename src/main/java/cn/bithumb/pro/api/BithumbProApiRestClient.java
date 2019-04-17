package cn.bithumb.pro.api;

import cn.bithumb.pro.api.model.market.*;

import java.util.List;

public interface BithumbProApiRestClient {

    BaseResponse<List<Ticker>> ticker(String symbol);

    BaseResponse<OrderBook> orderBook(String symbol);

    BaseResponse<List<Trade>> trades(String symbol);
}
