package cn.bithumb.pro.api.model.contract.res;

/**
 * 
 * @author lichen@oneroot.exchange
 *
 *         2019年5月30日
 *
 */
public class ContractAccountInfo {

	private String coin;
	private String totalAmount;
	private String remainMargin;
	private String openPositionMargin;
	private String openOrderMarginTotal;
	private String availableAmount;
	private String version;

	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getRemainMargin() {
		return remainMargin;
	}

	public void setRemainMargin(String remainMargin) {
		this.remainMargin = remainMargin;
	}

	public String getOpenPositionMargin() {
		return openPositionMargin;
	}

	public void setOpenPositionMargin(String openPositionMargin) {
		this.openPositionMargin = openPositionMargin;
	}

	public String getOpenOrderMarginTotal() {
		return openOrderMarginTotal;
	}

	public void setOpenOrderMarginTotal(String openOrderMarginTotal) {
		this.openOrderMarginTotal = openOrderMarginTotal;
	}

	public String getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(String availableAmount) {
		this.availableAmount = availableAmount;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
