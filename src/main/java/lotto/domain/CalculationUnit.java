package lotto.domain;

public enum CalculationUnit {
    USER_MONEY_PRICE(1000),
    PERCENTAGE(100),
    ROUND_UP_TO_TWO_DECIMAL_PLACES(100);

    private final int unit;

    CalculationUnit(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }
}
