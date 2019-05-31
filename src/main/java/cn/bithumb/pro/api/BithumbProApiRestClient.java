package cn.bithumb.pro.api;

import java.util.List;
import java.util.Map;

import cn.bithumb.pro.api.model.BaseResponse;
import cn.bithumb.pro.api.model.Config;
import cn.bithumb.pro.api.model.NewOrder;
import cn.bithumb.pro.api.model.OrderQuery;
import cn.bithumb.pro.api.model.account.Asset;
import cn.bithumb.pro.api.model.account.MyTrades;
import cn.bithumb.pro.api.model.contract.req.ContractOrder;
import cn.bithumb.pro.api.model.contract.res.ContractAccountInfo;
import cn.bithumb.pro.api.model.contract.res.ContractInfo;
import cn.bithumb.pro.api.model.contract.res.ContractOrderBook;
import cn.bithumb.pro.api.model.contract.res.ContractPosition;
import cn.bithumb.pro.api.model.contract.res.ContractTicker;
import cn.bithumb.pro.api.model.market.Kline;
import cn.bithumb.pro.api.model.market.OrderBook;
import cn.bithumb.pro.api.model.market.Ticker;
import cn.bithumb.pro.api.model.market.Trade;
import retrofit2.http.Body;

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
    
    /**
     * 合约下单
     * 
     * @param contractOrder
     * @return
     */
    BaseResponse<Map<String, Object>> createContractOrder(@Body ContractOrder contractOrder);
    
    /**
     * 合约取消订单
     * 
     * @param orderId
     * @return
     */
    BaseResponse<Map<String, Object>> cancelContractOrder(String orderId);
    
    /**
     *  修改杠杆
     * 
     * @param symbol
     * @param leverage
     * @return
     */
    BaseResponse<Map<String, Object>> updateLeverage(String symbol,String leverage);
    
    /**
     *  修改杠杆
     * 
     * @param symbol
     * @return
     */
    BaseResponse<ContractPosition> position(String symbol);
    
    /**
     *  调整保证金
     * 
     * @param symbol
     * @param changeAmount
     * @return
     */
    BaseResponse<Map<String, Object>> updateMargin(String symbol,String changeAmount);
    
    /**
     *  合约资产查询
     * 
     * @param page
     * @param count
     * @param coinIdLike
     * @return
     */
    BaseResponse<Map<String, Object>> contractAsset(String page,String count,String coinIdLike);
    
    /**
     * 查询用户私有合约信息
     * 
     * @param symbol
     * @return
     */
    BaseResponse<ContractInfo> contractInfo(String symbol);
    
    /**
     * 查询用户私有合约信息
     * 
     * @param coin
     * @return
     */
    BaseResponse<ContractAccountInfo> contractAccountInfo(String coin);
    
    /**
     *  合约资产查询
     * 
     * @param symbol
     * @param type
     * @param page
     * @param count
     * @return
     */
    BaseResponse<Map<String, Object>> contractOrders(String symbol,String type,String page,String count);
    

    /**
     * 查询用户合约的交易记录
     * 
     * @param symbol
     * @param page
     * @param count
     * @return
     */
    BaseResponse<Map<String, Object>> contractTrades(String symbol,String page,String count);
    
    /**
     * 提币
     * 
     * @param coinType
     * @param address
     * @param extendParam
     * @param quantity
     * @param mark
     * @return
     */
    BaseResponse<Map<String, Object>> withdraw(String coinType,String address,String extendParam,String quantity,String mark);
    
    /**
     * 内部账户资产划转
     * 
     * @param coinType
     * @param quantity
     * @param from
     * @param to
     * @return
     */
    BaseResponse<Map<String, Object>> transfer(String coinType,String quantity,String from,String to);

}
