package cn.bithumb.pro.api.model.contract;

/**
 * 
 * @author lichen@oneroot.exchange
 *
 *         2019年5月30日
 *
 */
public class ContractTicker {

	private String symbol;
	private String type;
	private String lastPrice;
	private String high;
	private String low;
	private String volume;
	private String change;
	private String openValue;
	private String fundRate0;
	private String fundTime0;
	private String adlRanker;
	private String ver;
	private String openInterest;
	private String turnover;

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

	public String getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(String lastPrice) {
		this.lastPrice = lastPrice;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getOpenValue() {
		return openValue;
	}

	public void setOpenValue(String openValue) {
		this.openValue = openValue;
	}

	public String getFundRate0() {
		return fundRate0;
	}

	public void setFundRate0(String fundRate0) {
		this.fundRate0 = fundRate0;
	}

	public String getFundTime0() {
		return fundTime0;
	}

	public void setFundTime0(String fundTime0) {
		this.fundTime0 = fundTime0;
	}

	public String getAdlRanker() {
		return adlRanker;
	}

	public void setAdlRanker(String adlRanker) {
		this.adlRanker = adlRanker;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public String getOpenInterest() {
		return openInterest;
	}

	public void setOpenInterest(String openInterest) {
		this.openInterest = openInterest;
	}

	public String getTurnover() {
		return turnover;
	}

	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}

}
