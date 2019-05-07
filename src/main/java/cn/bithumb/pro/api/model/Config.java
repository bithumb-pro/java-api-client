package cn.bithumb.pro.api.model;

import java.util.List;

public class Config {

    private List<CoinConfig> coinConfig;
    private List<SpotConfig> spotConfig;
    private List<ContractConfig> contractConfig;

    public List<CoinConfig> getCoinConfig() {
        return coinConfig;
    }

    public void setCoinConfig(List<CoinConfig> coinConfig) {
        this.coinConfig = coinConfig;
    }

    public List<SpotConfig> getSpotConfig() {
        return spotConfig;
    }

    public void setSpotConfig(List<SpotConfig> spotConfig) {
        this.spotConfig = spotConfig;
    }

    public List<ContractConfig> getContractConfig() {
        return contractConfig;
    }

    public void setContractConfig(List<ContractConfig> contractConfig) {
        this.contractConfig = contractConfig;
    }

    static class SpotConfig {
        private String symbol;
        private String[] accuracy;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String[] getAccuracy() {
            return accuracy;
        }

        public void setAccuracy(String[] accuracy) {
            this.accuracy = accuracy;
        }
    }

    static class ContractConfig {
        private String symbol;
        private String makerFeeRate;
        private String takerFeeRate;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getMakerFeeRate() {
            return makerFeeRate;
        }

        public void setMakerFeeRate(String makerFeeRate) {
            this.makerFeeRate = makerFeeRate;
        }

        public String getTakerFeeRate() {
            return takerFeeRate;
        }

        public void setTakerFeeRate(String takerFeeRate) {
            this.takerFeeRate = takerFeeRate;
        }
    }

    static class CoinConfig {
        private String name;
        private String fullName;
        private String depositStatus;
        private String withDrawStatus;
        private String minWithDraw;
        private String withDrawFee;
        private String makerFeeRate;
        private String takerFeeRate;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getDepositStatus() {
            return depositStatus;
        }

        public void setDepositStatus(String depositStatus) {
            this.depositStatus = depositStatus;
        }

        public String getWithDrawStatus() {
            return withDrawStatus;
        }

        public void setWithDrawStatus(String withDrawStatus) {
            this.withDrawStatus = withDrawStatus;
        }

        public String getMinWithDraw() {
            return minWithDraw;
        }

        public void setMinWithDraw(String minWithDraw) {
            this.minWithDraw = minWithDraw;
        }

        public String getWithDrawFee() {
            return withDrawFee;
        }

        public void setWithDrawFee(String withDrawFee) {
            this.withDrawFee = withDrawFee;
        }

        public String getMakerFeeRate() {
            return makerFeeRate;
        }

        public void setMakerFeeRate(String makerFeeRate) {
            this.makerFeeRate = makerFeeRate;
        }

        public String getTakerFeeRate() {
            return takerFeeRate;
        }

        public void setTakerFeeRate(String takerFeeRate) {
            this.takerFeeRate = takerFeeRate;
        }
    }
}
