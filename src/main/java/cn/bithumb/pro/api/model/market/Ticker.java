package cn.bithumb.pro.api.model.market;

public class Ticker {
    //24小时最新成交价
    private String c;
    //24小时最高价
    private String h;
    //24小时最低价
    private String l;
    //24小时涨跌幅
    private String p;
    //24小时成交量
    private String v;
    //币种
    private String s;
    private String ver;

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }
}
