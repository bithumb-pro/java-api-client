package cn.bithumb.pro.api.service;

import cn.bithumb.pro.api.constants.BithumbProApiConstants;
import cn.bithumb.pro.api.model.BaseResponse;
import cn.bithumb.pro.api.model.Config;
import cn.bithumb.pro.api.model.account.Asset;
import cn.bithumb.pro.api.model.account.MyTrades;
import cn.bithumb.pro.api.model.market.Kline;
import cn.bithumb.pro.api.model.market.OrderBook;
import cn.bithumb.pro.api.model.market.Ticker;
import cn.bithumb.pro.api.model.market.Trade;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

public interface BithumbProApiService {

    String base = "/openapi/v1";
    String base_spot = base + "/spot";

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
    Call<BaseResponse<Map<String, Object>>> cancelOrder(@Query("coinType") String coinType, @Query("marketType") String marketType,
                                                        @Query("orderId") String orderId);

    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_spot + "/assetList")
    Call<BaseResponse<List<Asset>>> assets(@Query("coinType") String coinType, @Query("assetType") String assetType);

    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_spot + "/orderDetail")
    Call<BaseResponse<Map<String, Object>>> orderDetail(@Query("coinType") String coinType, @Query("marketType") String marketType,
                                                        @Query("orderId") String orderId, @Query("page") Integer page,
                                                        @Query("count") Integer count);

    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_spot + "/orderList")
    Call<BaseResponse<Map<String, Object>>> orderList(@Query("coinType") String coinType, @Query("marketType") String marketType,
                                                      @Query("side") String side, @Query("status") String status,
                                                      @Query("queryRange") String queryRange, @Query("page") Integer page,
                                                      @Query("count") Integer count);

    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_spot + "/openOrders")
    Call<BaseResponse<Map<String, Object>>> openOrders(@Query("symbol") String symbol, @Query("page") Integer page,
                                                      @Query("count") Integer count);

    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_spot + "/singleOrder")
    Call<BaseResponse<Map<String, Object>>> singleOrder(@Query("coinType") String coinType, @Query("marketType") String marketType,
                                                        @Query("orderId") String orderId);

    @Headers({BithumbProApiConstants.SECURITY_SIGN_TAG_HEADER})
    @POST(base_spot + "/myTrades")
    Call<BaseResponse<List<MyTrades>>> myTrades(@Query("symbol") String symbol, @Query("startTime") Long startTime,
                                                @Query("limit") Integer limit);

}

