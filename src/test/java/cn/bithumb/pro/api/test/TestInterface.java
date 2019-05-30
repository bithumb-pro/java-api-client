package cn.bithumb.pro.api.test;

import cn.bithumb.pro.api.BithumbProApiClientFactory;
import cn.bithumb.pro.api.BithumbProApiRestClient;
import cn.bithumb.pro.api.JsonUtil;
import cn.bithumb.pro.api.constants.OrderSideEnum;
import cn.bithumb.pro.api.constants.OrderTypeEnum;
import cn.bithumb.pro.api.model.NewOrder;
import cn.bithumb.pro.api.model.OrderQuery;

public class TestInterface {

    private final static String apiKey = "ee18c627ce39d81c4c10dcce6d962dcd";
    private final static String secretKey = "9af5474ca96a536a8e889485e63906200e87b15475baab19427bc11f588d8184";

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
        String orderId = "54774088558211072";
        String symbol = "BCH-BTC";
        System.out.println(JsonUtil.objToJson(restClient.cancelOrder(orderId, symbol)));
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
        orderQuery.setSymbol("BCH-BTC");
        orderQuery.setOrderId("54806602685378560");
        System.out.println(JsonUtil.objToJson(restClient.orderDetail(orderQuery)));
    }

    private static void testOrderList() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        OrderQuery orderQuery = new OrderQuery();
        orderQuery.setSymbol("BCH-BTC");
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
        orderQuery.setOrderId("54806602685378560");
        orderQuery.setSymbol("BCH-BTC");
        System.out.println(JsonUtil.objToJson(restClient.singleOrder(orderQuery)));
    }

    private static void testMyTrades() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String symbol = "RNT-USDT";
        Long startTime = System.currentTimeMillis();
        Integer limit = 1;
        System.out.println(JsonUtil.objToJson(restClient.myTrades(symbol, startTime, limit)));
    }
    
    private static void testContractOrderBook() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String symbol = "BCH-BTC";
        System.out.println(JsonUtil.objToJson(restClient.contractOrderBook(symbol)));
    }
    
    private static void testContractTicker() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String symbol = "BCH-BTC";
        System.out.println(JsonUtil.objToJson(restClient.contractTicker(symbol)));
    }

    public static void main(String[] args) {

//        testCreateOrder();

//        testCancelOrder();

       testAssets();

//        testOrderDetail();

//        testSingleOrder();

//        testOpenOrders();

//        testOrderList();

//        testMyTrades();
    	
//    	testContractOrderBook() ;
    	
//    	testContractTicker();


    }

}
