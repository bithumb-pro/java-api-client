package cn.bithumb.pro.api.model.contract.res;

/**
 * 
 * @author lichen@oneroot.exchange
 *
 * 2019年5月30日
 *
 */
public class ContractPosition {

	private String positionId;
	private String symbol;
	private String amount;
	private String margin;
	private String positionValue;
	private String leverage;
	private String status;
	private String openPositionTime;
	private String flatPositionTime;
	private String realProfit;
	private String liquidation;
	private String side;
	private String frozen;

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMargin() {
		return margin;
	}

	public void setMargin(String margin) {
		this.margin = margin;
	}

	public String getPositionValue() {
		return positionValue;
	}

	public void setPositionValue(String positionValue) {
		this.positionValue = positionValue;
	}

	public String getLeverage() {
		return leverage;
	}

	public void setLeverage(String leverage) {
		this.leverage = leverage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOpenPositionTime() {
		return openPositionTime;
	}

	public void setOpenPositionTime(String openPositionTime) {
		this.openPositionTime = openPositionTime;
	}

	public String getFlatPositionTime() {
		return flatPositionTime;
	}

	public void setFlatPositionTime(String flatPositionTime) {
		this.flatPositionTime = flatPositionTime;
	}

	public String getRealProfit() {
		return realProfit;
	}

	public void setRealProfit(String realProfit) {
		this.realProfit = realProfit;
	}

	public String getLiquidation() {
		return liquidation;
	}

	public void setLiquidation(String liquidation) {
		this.liquidation = liquidation;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getFrozen() {
		return frozen;
	}

	public void setFrozen(String frozen) {
		this.frozen = frozen;
	}
}
