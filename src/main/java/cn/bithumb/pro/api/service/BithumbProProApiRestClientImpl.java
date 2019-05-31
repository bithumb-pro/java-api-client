package cn.bithumb.pro.api.service;

import java.util.List;
import java.util.Map;

import cn.bithumb.pro.api.BithumbProApiRestClient;
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

public class BithumbProProApiRestClientImpl implements BithumbProApiRestClient {

    private final BithumbProApiService bithumbProApiService;

    public BithumbProProApiRestClientImpl(String apiKey, String secret) {
        bithumbProApiService = BithumbProApiCore.createService(BithumbProApiService.class, apiKey, secret);
    }


    @Override
    public BaseResponse<Long> serverTime() {
        return BithumbProApiCore.executeSync(bithumbProApiService.serverTime());
    }

    @Override
    public BaseResponse<List<Ticker>> ticker(String symbol) {
        return BithumbProApiCore.executeSync(bithumbProApiService.ticker(symbol));
    }

    @Override
    public BaseResponse<OrderBook> orderBook(String symbol) {
        return BithumbProApiCore.executeSync(bithumbProApiService.orderBook(symbol));
    }

    @Override
    public BaseResponse<List<Trade>> trades(String symbol) {
        return BithumbProApiCore.executeSync(bithumbProApiService.trades(symbol));
    }

    @Override
    public BaseResponse<List<Kline>> kline(String symbol, String type, Long startTime, Long endTime) {
        return BithumbProApiCore.executeSync(bithumbProApiService.kline(symbol, type, startTime, endTime));
    }

    @Override
    public BaseResponse<Config> config() {
        return BithumbProApiCore.executeSync(bithumbProApiService.config());
    }

    @Override
    public BaseResponse<Map<String, Object>> createOrder(NewOrder newOrder) {
        return BithumbProApiCore.executeSync(bithumbProApiService.newOrder(newOrder.getSymbol(), newOrder.getType(),
                newOrder.getSide(), newOrder.getPrice(),
                newOrder.getQuantity(), newOrder.getTimestamp(), newOrder.getMsgNo()));
    }

    @Override
    public BaseResponse<Map<String, Object>> cancelOrder(String orderId, String symbol) {
        return BithumbProApiCore.executeSync(bithumbProApiService.cancelOrder(symbol, orderId));
    }

    @Override
    public BaseResponse<List<Asset>> assets(String coinType, String assetType) {
        return BithumbProApiCore.executeSync(bithumbProApiService.assets(coinType, assetType));
    }

    @Override
    public BaseResponse<Map<String, Object>> orderDetail(OrderQuery orderQuery) {
        return BithumbProApiCore.executeSync(bithumbProApiService.orderDetail(orderQuery.getSymbol(), orderQuery.getOrderId(),
                orderQuery.getPage(), orderQuery.getCount()));
    }

    @Override
    public BaseResponse<Map<String, Object>> orders(OrderQuery orderQuery) {
        return BithumbProApiCore.executeSync(bithumbProApiService.orderList(orderQuery.getSymbol(), orderQuery.getSide(),
                orderQuery.getStatus(), orderQuery.getQueryRange(), orderQuery.getPage(), orderQuery.getCount()));
    }

    @Override
    public BaseResponse<Map<String, Object>> openOrders(OrderQuery orderQuery) {
        return BithumbProApiCore.executeSync(bithumbProApiService.openOrders(orderQuery.getSymbol(), orderQuery.getPage(), orderQuery.getCount()));
    }

    @Override
    public BaseResponse<Map<String, Object>> singleOrder(OrderQuery orderQuery) {
        return BithumbProApiCore.executeSync(bithumbProApiService.singleOrder(orderQuery.getSymbol(), orderQuery.getOrderId()));
    }

    @Override
    public BaseResponse<List<MyTrades>> myTrades(String symbol, Long startTime, Integer limit) {
        return BithumbProApiCore.executeSync(bithumbProApiService.myTrades(symbol, startTime, limit));
    }

	@Override
	public BaseResponse<ContractOrderBook> contractOrderBook(String symbol) {
		return BithumbProApiCore.executeSync(bithumbProApiService.contractOrderBook(symbol));
	}

	@Override
	public BaseResponse<ContractTicker> contractTicker(String symbol) {
		return BithumbProApiCore.executeSync(bithumbProApiService.contractTicker(symbol));
	}

	@Override
	public BaseResponse<Map<String, Object>> createContractOrder(ContractOrder contractOrder) {
		return BithumbProApiCore.executeSync(bithumbProApiService.createContractOrder(contractOrder));
	}

	@Override
	public BaseResponse<Map<String, Object>> cancelContractOrder(String orderId) {
		return BithumbProApiCore.executeSync(bithumbProApiService.cancelContractOrder(orderId));
	}

	@Override
	public BaseResponse<Map<String, Object>> updateLeverage(String symbol, String leverage) {
		return BithumbProApiCore.executeSync(bithumbProApiService.updateLeverage(symbol,leverage));
	}

	@Override
	public BaseResponse<ContractPosition> position(String symbol) {
		return BithumbProApiCore.executeSync(bithumbProApiService.position(symbol));
	}

	@Override
	public BaseResponse<Map<String, Object>> updateMargin(String symbol, String updateMargin) {
		return BithumbProApiCore.executeSync(bithumbProApiService.updateMargin(symbol,updateMargin));
	}

	@Override
	public BaseResponse<Map<String, Object>> contractAsset(String page, String count, String coinIdLike) {
		return BithumbProApiCore.executeSync(bithumbProApiService.contractAsset(page, count, coinIdLike));
	}

	@Override
	public BaseResponse<ContractInfo> contractInfo(String symbol) {
		return BithumbProApiCore.executeSync(bithumbProApiService.contractInfo(symbol));
	}

	@Override
	public BaseResponse<ContractAccountInfo> contractAccountInfo(String coin) {
		return BithumbProApiCore.executeSync(bithumbProApiService.contractAccountInfo(coin));
	}

	@Override
	public BaseResponse<Map<String, Object>> contractOrders(String symbol, String type, String page, String count) {
		return BithumbProApiCore.executeSync(bithumbProApiService.contractOrders(symbol,type,page,count));
	}

	@Override
	public BaseResponse<Map<String, Object>> contractTrades(String symbol, String page, String count) {
		return BithumbProApiCore.executeSync(bithumbProApiService.contractTrades(symbol,page,count));
	}

	@Override
	public BaseResponse<Map<String, Object>> withdraw(String coinType, String address, String extendParam,
			String quantity, String mark) {
		return BithumbProApiCore.executeSync(bithumbProApiService.withdraw(coinType, address, extendParam,
				 quantity, mark));
	}

	@Override
	public BaseResponse<Map<String, Object>> transfer(String coinType, String quantity, String from, String to) {
		return BithumbProApiCore.executeSync(bithumbProApiService.transfer(coinType, quantity, from, to));
	}

}
