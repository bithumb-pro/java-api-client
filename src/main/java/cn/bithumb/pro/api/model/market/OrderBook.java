package cn.bithumb.pro.api.model.market;

import java.util.ArrayList;
import java.util.List;

public class OrderBook {
    private String symbol;
    private String ver;
    //买
    private List<String[]> b = new ArrayList<>();
    //卖
    private List<String[]> s = new ArrayList<>();

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
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
