package cn.bithumb.pro.api;

import cn.bithumb.pro.api.model.BaseResponse;
import cn.bithumb.pro.api.model.Config;
import cn.bithumb.pro.api.model.NewOrder;
import cn.bithumb.pro.api.model.OrderQuery;
import cn.bithumb.pro.api.model.account.Asset;
import cn.bithumb.pro.api.model.market.Kline;
import cn.bithumb.pro.api.model.market.OrderBook;
import cn.bithumb.pro.api.model.market.Ticker;
import cn.bithumb.pro.api.model.market.Trade;

import java.util.List;
import java.util.Map;

public interface BithumbProApiRestClient {

    BaseResponse<List<Ticker>> ticker(String symbol);

    BaseResponse<OrderBook> orderBook(String symbol);

    BaseResponse<List<Trade>> trades(String symbol);

    BaseResponse<List<Kline>> kline(String symbol, String type, Long start, Long end);

    BaseResponse<Config> spotConfig();

    BaseResponse<Map<String, Object>> createOrder(NewOrder newOrder);

    BaseResponse<Map<String, Object>> cancelOrder(String orderId, String coinType, String marketType);

    BaseResponse<List<Asset>> assets(String coinType, String assetType);

    /**
     * @param orderQuery
     * orderId
     * coinType
     * marketType
     * page
     * count
     *
     * @return
     */
    BaseResponse<Map<String, Object>> orderDetail(OrderQuery orderQuery);

    /**
     * @param orderQuery
     * coinType
     * marketType
     * side
     * status
     * queryRange
     * page
     * count
     *
     * @return
     */
    BaseResponse<Map<String, Object>> orders(OrderQuery orderQuery);

    /**
     * @param orderQuery
     * symbol
     * page
     * count
     *
     * @return
     */
    BaseResponse<Map<String, Object>> openOrders(OrderQuery orderQuery);

    /**
     * @param orderQuery
     * orderId
     * coinType
     * marketType
     *
     * @return
     */
    BaseResponse<Map<String, Object>> singleOrder(OrderQuery orderQuery);

}
