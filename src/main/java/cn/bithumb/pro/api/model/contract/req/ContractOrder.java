package cn.bithumb.pro.api.model.contract.req;

/**
 * 
 * @author lichen@oneroot.exchange
 *
 * 2019年5月30日
 *
 */
public class ContractOrder {

	private String property;
	private String symbol;
	private String type;
	private String amount;
	private String amountDisplay;
	private String price;
	private String side;
	private String postOnly;
	private String reduceOnly;
	private String timeInForce;
	private String leverage;
	private String triggerPrice;
	private String benchmarkPrice;
	private String triggerPriceType;
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAmountDisplay() {
		return amountDisplay;
	}
	public void setAmountDisplay(String amountDisplay) {
		this.amountDisplay = amountDisplay;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getPostOnly() {
		return postOnly;
	}
	public void setPostOnly(String postOnly) {
		this.postOnly = postOnly;
	}
	public String getReduceOnly() {
		return reduceOnly;
	}
	public void setReduceOnly(String reduceOnly) {
		this.reduceOnly = reduceOnly;
	}
	public String getTimeInForce() {
		return timeInForce;
	}
	public void setTimeInForce(String timeInForce) {
		this.timeInForce = timeInForce;
	}
	public String getLeverage() {
		return leverage;
	}
	public void setLeverage(String leverage) {
		this.leverage = leverage;
	}
	public String getTriggerPrice() {
		return triggerPrice;
	}
	public void setTriggerPrice(String triggerPrice) {
		this.triggerPrice = triggerPrice;
	}
	public String getBenchmarkPrice() {
		return benchmarkPrice;
	}
	public void setBenchmarkPrice(String benchmarkPrice) {
		this.benchmarkPrice = benchmarkPrice;
	}
	public String getTriggerPriceType() {
		return triggerPriceType;
	}
	public void setTriggerPriceType(String triggerPriceType) {
		this.triggerPriceType = triggerPriceType;
	}
	
	
}
