package cn.bithumb.pro.api.service;

import cn.bithumb.pro.api.model.market.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface BithumbProApiService {

  String base = "/openapi/api";

  @GET(base + "/spot/ticker")
  Call<BaseResponse<List<Ticker>>> ticker(@Query("symbol") String symbol);

  @GET(base + "/spot/orderBook")
  Call<BaseResponse<OrderBook>> orderBook(@Query("symbol") String symbol);

  @GET(base + "/spot/trades")
  Call<BaseResponse<List<Trade>>> trades(@Query("symbol") String symbol);

  @GET(base + "/spot/kline")
  Call<BaseResponse<Kline>> kline(@Query("symbol") String symbol);

}
