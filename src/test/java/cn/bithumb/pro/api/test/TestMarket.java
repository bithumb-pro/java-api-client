package cn.bithumb.pro.api.test;

import cn.bithumb.pro.api.BithumbProApiClientFactory;
import cn.bithumb.pro.api.BithumbProApiRestClient;
import cn.bithumb.pro.api.JsonUtil;
import cn.bithumb.pro.api.constants.KlineEnum;
import cn.bithumb.pro.api.model.market.Kline;

public class TestMarket {

    private static void testConfig() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance();
        BithumbProApiRestClient restClient = factory.newRestClient();
        System.out.println(JsonUtil.objToJson(restClient.spotConfig()));
    }

    private static void testTicker() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance();
        BithumbProApiRestClient restClient = factory.newRestClient();
        System.out.println(JsonUtil.objToJson(restClient.ticker("BCH-BTC")));
    }

    private static void testOrderBook() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance();
        BithumbProApiRestClient restClient = factory.newRestClient();
        System.out.println(JsonUtil.objToJson(restClient.orderBook("BCH-BTC")));
    }

    private static void testTrades() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance();
        BithumbProApiRestClient restClient = factory.newRestClient();
        System.out.println(JsonUtil.objToJson(restClient.trades("BCH-BTC")));
    }

    private static void testKline() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance();
        BithumbProApiRestClient restClient = factory.newRestClient();
//        String symbol = "BCH-BTC";
//        String type = KlineEnum.m1.name();
//        Long startTime = 1556252294L;
//        Long endTime = 1556263095L;
        String symbol = "RNT-USDT";
        String type = KlineEnum.m1.name();
        Long startTime = 1555239630L;
        Long endTime = 1555249630L;
        System.out.println(JsonUtil.objToJson(restClient.kline(symbol, type, startTime, endTime)));
    }

    public static void main(String[] args) {

        testConfig();

        testTicker();

        testOrderBook();

        testTrades();

        testKline();

    }
}
