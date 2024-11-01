package lotto;

public enum CommonSymbols {
    NEW_LINE("\n");

    private final String symbol;

    CommonSymbols(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
