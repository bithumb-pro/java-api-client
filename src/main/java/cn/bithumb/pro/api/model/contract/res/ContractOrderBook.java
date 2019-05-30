package cn.bithumb.pro.api.model.contract.res;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lichen@oneroot.exchange
 *
 *         2019年5月30日
 *
 */
public class ContractOrderBook {

	private String type;
	
	private List<String[]> b = new ArrayList<>();
	
	private List<String[]> s = new ArrayList<>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String[]> getB() {
		return b;
	}

	public void setB(List<String[]> b) {
		this.b = b;
	}

	public List<String[]> getS() {
		return s;
	}

	public void setS(List<String[]> s) {
		this.s = s;
	}

}
