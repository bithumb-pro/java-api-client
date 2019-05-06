package cn.bithumb.pro.api.test;

import cn.bithumb.pro.api.BithumbProApiClientFactory;
import cn.bithumb.pro.api.BithumbProApiRestClient;
import cn.bithumb.pro.api.JsonUtil;
import cn.bithumb.pro.api.constants.OrderSideEnum;
import cn.bithumb.pro.api.constants.OrderTypeEnum;
import cn.bithumb.pro.api.model.NewOrder;
import cn.bithumb.pro.api.model.OrderQuery;

public class TestInterface {

    private final static String apiKey = "";
    private final static String secretKey = "";


    private static void testCreateOrder() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        NewOrder newOrder = new NewOrder();
        newOrder.setSymbol("BCH-BTC");
        newOrder.setType(OrderTypeEnum.limit.name());
        newOrder.setSide(OrderSideEnum.buy.name());
        newOrder.setPrice("100.001");
        newOrder.setQuantity("10");
        newOrder.setTimestamp(System.currentTimeMillis());
        newOrder.setMsgNo("test");
        System.out.println(JsonUtil.objToJson(restClient.createOrder(newOrder)));
    }

    private static void testCancelOrder() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String orderId = "50504119475806208";
        String coinType = "BCH";
        String marketType = "BTC";
        System.out.println(JsonUtil.objToJson(restClient.cancelOrder(orderId, coinType, marketType)));
    }

    private static void testAssets() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String coinType = null;
        String assetType = "spot";
        System.out.println(JsonUtil.objToJson(restClient.assets(coinType, assetType)));
    }

    private static void testOrderDetail() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        OrderQuery orderQuery = new OrderQuery();
        orderQuery.setCoinType("BCH");
        orderQuery.setMarketType("BTC");
        orderQuery.setOrderId("50504119475806208");
        System.out.println(JsonUtil.objToJson(restClient.orderDetail(orderQuery)));
    }

    private static void testOrderList() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        OrderQuery orderQuery = new OrderQuery();
        orderQuery.setCoinType("BCH");
        orderQuery.setMarketType("BTC");
        orderQuery.setStatus("traded");
        System.out.println(JsonUtil.objToJson(restClient.orders(orderQuery)));
    }

    private static void testOpenOrders() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        OrderQuery orderQuery = new OrderQuery();
        orderQuery.setSymbol("BCH-BTC");
        System.out.println(JsonUtil.objToJson(restClient.openOrders(orderQuery)));
    }

    private static void testSingleOrder() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        OrderQuery orderQuery = new OrderQuery();
        orderQuery.setOrderId("50504119475806208");
        orderQuery.setCoinType("BCH");
        orderQuery.setMarketType("BTC");
        System.out.println(JsonUtil.objToJson(restClient.singleOrder(orderQuery)));
    }

    private static void testMyTrades() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String symbol = "RNT-USDT";
        Long startTime = System.currentTimeMillis();
        Integer limit = 100;
        System.out.println(JsonUtil.objToJson(restClient.myTrades(symbol, startTime, limit)));
    }

    public static void main(String[] args) {

//        testCreateOrder();

//        testCancelOrder();

//        testAssets();

//        testOrderDetail();

//        testSingleOrder();

//        testOpenOrders();

//        testOrderList();

//        testMyTrades();

    }

}
