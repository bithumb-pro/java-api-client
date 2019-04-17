package cn.bithumb.pro.api.model.market;

public class Kline {

    private String c;
    //high
    private String h;
    //low
    private String l;
    //open
    private String o;
    //sum(累计成交额)
    private String s;
    //total(累计成交笔数)
    private String t;
    //time(时间戳：秒)
    private String time;
    //volumn(成交量)
    private String v;

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

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }
}
