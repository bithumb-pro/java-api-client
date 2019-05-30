package cn.bithumb.pro.api.model.contract.res;

/**
 * 
 * @author lichen@oneroot.exchange
 *
 *         2019年5月30日
 *
 */
public class ContractInfo {

	private String symbol;
	private String leverage;
	private String fundRate0;
	private String riskLimit;
	private String version;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getLeverage() {
		return leverage;
	}

	public void setLeverage(String leverage) {
		this.leverage = leverage;
	}

	public String getFundRate0() {
		return fundRate0;
	}

	public void setFundRate0(String fundRate0) {
		this.fundRate0 = fundRate0;
	}

	public String getRiskLimit() {
		return riskLimit;
	}

	public void setRiskLimit(String riskLimit) {
		this.riskLimit = riskLimit;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
