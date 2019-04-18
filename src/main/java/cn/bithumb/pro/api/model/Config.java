package cn.bithumb.pro.api.model;

import java.util.List;

public class Config {
    private List<SymbolConfig> symbolConfig;

    public List<SymbolConfig> getSymbolConfig() {
        return symbolConfig;
    }

    public void setSymbolConfig(List<SymbolConfig> symbolConfig) {
        this.symbolConfig = symbolConfig;
    }

    static class SymbolConfig {
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
}
