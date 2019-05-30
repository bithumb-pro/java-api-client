package cn.bithumb.pro.api;

import java.util.List;
import java.util.Map;

import cn.bithumb.pro.api.model.BaseResponse;
import cn.bithumb.pro.api.model.Config;
import cn.bithumb.pro.api.model.NewOrder;
import cn.bithumb.pro.api.model.OrderQuery;
import cn.bithumb.pro.api.model.account.Asset;
import cn.bithumb.pro.api.model.account.MyTrades;
import cn.bithumb.pro.api.model.contract.ContractOrderBook;
import cn.bithumb.pro.api.model.contract.ContractTicker;
import cn.bithumb.pro.api.model.market.Kline;
import cn.bithumb.pro.api.model.market.OrderBook;
import cn.bithumb.pro.api.model.market.Ticker;
import cn.bithumb.pro.api.model.market.Trade;

public interface BithumbProApiRestClient {

    BaseResponse<Long> serverTime();

    BaseResponse<List<Ticker>> ticker(String symbol);

    BaseResponse<OrderBook> orderBook(String symbol);

    BaseResponse<List<Trade>> trades(String symbol);

    BaseResponse<List<Kline>> kline(String symbol, String type, Long start, Long end);

    BaseResponse<Config> config();

    BaseResponse<Map<String, Object>> createOrder(NewOrder newOrder);

    BaseResponse<Map<String, Object>> cancelOrder(String orderId, String symbol);

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

    BaseResponse<List<MyTrades>> myTrades(String symbol, Long startTime, Integer limit);
    
    /**
     * 合约订单簿
     * 
     * @param symbol
     * @return
     */
    BaseResponse<ContractOrderBook> contractOrderBook(String symbol);
    
    /**
     * 合约行情
     * 
     * @param symbol
     * @return
     */
    BaseResponse<ContractTicker> contractTicker(String symbol);

}
