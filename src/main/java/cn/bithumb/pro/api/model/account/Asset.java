package cn.bithumb.pro.api.model.account;

public class Asset {
    private String coinType;
    private String count;
    private String frozen;
    private String type;
    private String btcQuantity;

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getFrozen() {
        return frozen;
    }

    public void setFrozen(String frozen) {
        this.frozen = frozen;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBtcQuantity() {
        return btcQuantity;
    }

    public void setBtcQuantity(String btcQuantity) {
        this.btcQuantity = btcQuantity;
    }
}
