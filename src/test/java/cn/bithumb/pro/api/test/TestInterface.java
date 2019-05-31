package cn.bithumb.pro.api.test;

import cn.bithumb.pro.api.BithumbProApiClientFactory;
import cn.bithumb.pro.api.BithumbProApiRestClient;
import cn.bithumb.pro.api.JsonUtil;
import cn.bithumb.pro.api.constants.OrderSideEnum;
import cn.bithumb.pro.api.constants.OrderTypeEnum;
import cn.bithumb.pro.api.model.NewOrder;
import cn.bithumb.pro.api.model.OrderQuery;
import cn.bithumb.pro.api.model.contract.req.ContractOrder;

public class TestInterface {

    private final static String apiKey = "40";
    private final static String secretKey = "4dd1b9b5b24911a3be9d1e16acb5541bffe4862cfb7eef0b3a52296687aeb157";

    private static void testCreateOrder() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        NewOrder newOrder = new NewOrder();
        newOrder.setSymbol("ETH-BTC");
        newOrder.setType(OrderTypeEnum.limit.name());
        newOrder.setSide(OrderSideEnum.buy.name());
        newOrder.setPrice("100");
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
    
    private static void testCreateContractOrder() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        ContractOrder contractOrder  = new ContractOrder();
        contractOrder.setProperty("normal");
        contractOrder.setSymbol("BTCUSD");
        contractOrder.setType("limit");
        contractOrder.setAmount("10");
        contractOrder.setAmountDisplay("100");
        contractOrder.setPrice("10");
        contractOrder.setSide("buy");
        contractOrder.setPostOnly("fasle");
        contractOrder.setReduceOnly("false");
        contractOrder.setTimeInForce("GTC");
        contractOrder.setLeverage(null);
        contractOrder.setTriggerPrice(null);
        contractOrder.setBenchmarkPrice(null);
        contractOrder.setTriggerPriceType(null);
        System.out.println(JsonUtil.objToJson(restClient.createContractOrder(contractOrder)));
    }

    private static void testContractCancelOrder() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String orderId = "12345";
        System.out.println(JsonUtil.objToJson(restClient.cancelContractOrder(orderId)));
    }
    
    private static void testUpdateLeverage() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String symbol = "BCH-BTC";
        String leverage = "1";
        System.out.println(JsonUtil.objToJson(restClient.updateLeverage(symbol,leverage)));
    }
    
    private static void testPosition() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String symbol = "BCH-BTC";
        System.out.println(JsonUtil.objToJson(restClient.position(symbol)));
    }
    
    private static void testUpdageMargin() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String symbol = "BCH-BTC";
        String changeAmount = "10000";
        System.out.println(JsonUtil.objToJson(restClient.updateMargin(symbol,changeAmount)));
    }
    
    private static void testContractAsset() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String page	 = "1";
        String count = "10";
        String coinIdLike = "BTC";
        System.out.println(JsonUtil.objToJson(restClient.contractAsset(page,count,coinIdLike)));
    }
    
    private static void testContractInfo() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String symbol = "BCH-BTC";
        System.out.println(JsonUtil.objToJson(restClient.contractInfo(symbol)));
    }
    
    private static void testContractAccountInfo() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String coin = "BCH-BTC";
        System.out.println(JsonUtil.objToJson(restClient.contractAccountInfo(coin)));
    }
    
    private static void testContractOrder() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String symbol = "TBTCUSD";
        String type = "history";
        System.out.println(JsonUtil.objToJson(restClient.contractOrders(symbol,type,"1","10")));
    }
    
    private static void testContractTrades() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String symbol = "TBTCUSD";
        String page	 = "1";
        String count = "10";
        System.out.println(JsonUtil.objToJson(restClient.contractTrades(symbol,page,count)));
    }
    
    private static void testWithdraw() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String coinType = "BTC";
        String address	 = "12345";
        String extendParam = "10";
        String quantity = "10";
        String mark = "10";
        System.out.println(JsonUtil.objToJson(restClient.withdraw(coinType,address,extendParam,quantity,mark)));
    }
    
    private static void testTransfer() {
        BithumbProApiClientFactory factory = BithumbProApiClientFactory.newInstance(apiKey, secretKey);
        BithumbProApiRestClient restClient = factory.newRestClient();
        String coinType = "BTC";
        String quantity	 = "1";
        String from = "WALLET";
        String to = "SPOT";
        System.out.println(JsonUtil.objToJson(restClient.transfer(coinType,quantity,from,to)));
    }
    
    
    public static void main(String[] args) {

//        testCreateOrder();
//
//        testCancelOrder();
//
//        testAssets();
//
//        testOrderDetail();
//
//        testSingleOrder();
//
//        testOpenOrders();
//
//        testOrderList();
//
//        testMyTrades();
//
//    	testContractOrderBook() ;
//
//    	testContractTicker();
//
//    	testCreateContractOrder();
//
//    	testContractCancelOrder();
//
//    	testUpdateLeverage();
//
//    	testPosition();
//
//    	testUpdageMargin();
//
//    	testContractAsset();
//
//    	testContractInfo();
//
//    	testContractAccountInfo();
//
//    	testContractOrder();
//
//    	testContractTrades();
    	
//    	testWithdraw();
//    	
//    	testTransfer();

    }

}
