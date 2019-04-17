package cn.bithumb.pro.api.test;

import cn.bithumb.pro.api.BithumbProApiClientFactory;
import cn.bithumb.pro.api.BithumbProApiRestClient;
import cn.bithumb.pro.api.JsonUtil;

public class TestRest {

    public static void main(String[] args) {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance();
        BithumbProApiRestClient restClient = factory.newRestClient();
        String symbol = "BTC-USDT";
        System.out.println(JsonUtil.objToJson(restClient.ticker(symbol)));
        System.out.println(JsonUtil.objToJson(restClient.orderBook(symbol)));
    }
}
