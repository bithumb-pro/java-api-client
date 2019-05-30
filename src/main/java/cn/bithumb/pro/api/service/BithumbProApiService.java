package cn.bithumb.pro.api.service;

import java.util.List;
import java.util.Map;

import cn.bithumb.pro.api.constants.BithumbProApiConstants;
import cn.bithumb.pro.api.model.BaseResponse;
import cn.bithumb.pro.api.model.Config;
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
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BithumbProApiService {

    String base = "/openapi/v1";
    String base_spot = base + "/spot";
    String base_contract = base + "/contract";

    @GET(base + "/serverTime")
    Call<BaseResponse<Long>> serverTime();

    @GET(base_spot + "/ticker")
    Call<BaseResponse<List<Ticker>>> ticker(@Query("symbol") String symbol);

    @GET(base_spot + "/orderBook")
    Call<BaseResponse<OrderBook>> orderBook(@Query("symbol") String symbol);

    @GET(base_spot + "/trades")
    Call<BaseResponse<List<Trade>>> trades(@Query("symbol") String symbol);

    @GET(base_spot + "/kline")
    Call<BaseResponse<List<Kline>>> kline(@Query("symbol") String symbol, @Query("type") String type,
                                          @Query("start") Long startTime, @Query("end") Long endTime);

    @GET(base_spot + "/config")
    Call<BaseResponse<Config>> config();

    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_spot + "/placeOrder")
    Call<BaseResponse<Map<String, Object>>> newOrder(@Query("symbol") String symbol, @Query("type") String type,
                                                     @Query("side") String side, @Query("price") String price,
                                                     @Query("quantity") String quantity, @Query("timestamp") Long timestamp,
                                                     @Query("msgNo") String msgNo);

    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_spot + "/cancelOrder")
    Call<BaseResponse<Map<String, Object>>> cancelOrder(@Query("symbol") String symbol, @Query("orderId") String orderId);

    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_spot + "/assetList")
    Call<BaseResponse<List<Asset>>> assets(@Query("coinType") String coinType, @Query("assetType") String assetType);

    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_spot + "/orderDetail")
    Call<BaseResponse<Map<String, Object>>> orderDetail(@Query("symbol") String symbol, @Query("orderId") String orderId,
                                                        @Query("page") Integer page, @Query("count") Integer count);

    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_spot + "/orderList")
    Call<BaseResponse<Map<String, Object>>> orderList(@Query("symbol") String symbol, @Query("side") String side,
                                                      @Query("status") String status, @Query("queryRange") String queryRange,
                                                      @Query("page") Integer page, @Query("count") Integer count);

    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_spot + "/openOrders")
    Call<BaseResponse<Map<String, Object>>> openOrders(@Query("symbol") String symbol, @Query("page") Integer page,
                                                      @Query("count") Integer count);

    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_spot + "/singleOrder")
    Call<BaseResponse<Map<String, Object>>> singleOrder(@Query("symbol") String symbol, @Query("orderId") String orderId);

    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_spot + "/myTrades")
    Call<BaseResponse<List<MyTrades>>> myTrades(@Query("symbol") String symbol, @Query("startTime") Long startTime,
                                                @Query("limit") Integer limit);
    
    /**
     * 合约订单簿
     * 
     * @param symbol
     * @return
     */
    @GET(base_contract + "/orderBook")
    Call<BaseResponse<ContractOrderBook>> contractOrderBook(@Query("symbol") String symbol);

    /**
     * 合约行情
     * 
     * @param symbol
     * @return
     */
    @GET(base_contract + "/ticker")
    Call<BaseResponse<ContractTicker>> contractTicker(@Query("symbol") String symbol);
    
    /**
     * 合约下单
     * 
     * @param symbol
     * @return
     */
    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_contract + "/order/create")
    Call<BaseResponse<Map<String, Object>>> createContractOrder(@Body ContractOrder contractOrder);
    
    /**
     * 合约取消下单
     * 
     * @param orderId
     * @return
     */
    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_contract + "/order/cancel")
    Call<BaseResponse<Map<String, Object>>> cancelContractOrder(@Query("orderId") String orderId);
    
    /**
     * 修改杠杆
     * 
     * @param symbol
     * @param leverage
     * @return
     */
    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_contract + "/leverage/update")
    Call<BaseResponse<Map<String, Object>>> updateLeverage(@Query("symbol") String symbol, 
    		@Query("leverage") String leverage);
    
    /**
     * 仓位信息
     * 
     * @param symbol
     * @return
     */
    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_contract + "/position")
    Call<BaseResponse<ContractPosition>> position(@Query("symbol") String symbol);
    
    /**
     * 调整保证金
     * 
     * @param symbol
     * @param changeAmount
     * @return
     */
    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_contract + "/margin/update")
    Call<BaseResponse<Map<String, Object>>> updateMargin(@Query("symbol") String symbol, 
    		@Query("changeAmount") String changeAmount);
    
    /**
     * 合约资产查询
     * 
     * @param page
     * @param count
     * @param coinIdLike
     * @return
     */
    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_contract + "/asset/info")
    Call<BaseResponse<Map<String, Object>>> contractAsset(@Query("page") String page, 
    		@Query("count") String count,@Query("coinIdLike") String coinIdLike);
    
    /**
     * 查询用户私有合约信息
     * 
     * @param symbol
     * @return
     */
    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_contract + "/info")
    Call<BaseResponse<ContractInfo>> contractInfo(@Query("symbol") String symbol);
    
    /**
     * 查询用户合约账户信息
     * 
     * @param coin
     * @return
     */
    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_contract + "/account/info")
    Call<BaseResponse<ContractAccountInfo>> contractAccountInfo(@Query("coin") String coin);
    
    /**
     * 订单列表查询
     * 
     * @param symbol
     * @param type
     * @param page
     * @param count
     * @return
     */
    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_contract + "/orders")
    Call<BaseResponse<Map<String, Object>>> contractOrder(@Query("symbol") String symbol, 
    		@Query("type") String type,@Query("page") String page, @Query("count") String count);
    
    /**
     * 查询用户合约的交易记录
     * 
     * @param symbol
     * @param page
     * @param count
     * @return
     */
    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_contract + "/trades")
    Call<BaseResponse<Map<String, Object>>> contractTrades(@Query("symbol") String symbol, 
    		@Query("page") String page, @Query("count") String count);
    
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
    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base + "/withdraw")
    Call<BaseResponse<Map<String, Object>>> withdraw(@Query("coinType") String coinType, @Query("address") String address,
    		@Query("extendParam") String extendParam, @Query("quantity") String quantity, @Query("mark") String mark);
    
    /**
     * 内部账户资产划转
     * 
     * @param coinType
     * @param quantity
     * @param from
     * @param to
     * @return
     */
    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base + "/transfer")
    Call<BaseResponse<Map<String, Object>>> transfer(@Query("coinType") String coinType,
    		@Query("quantity") String quantity, @Query("from") String from, @Query("to") String to);
    
}

