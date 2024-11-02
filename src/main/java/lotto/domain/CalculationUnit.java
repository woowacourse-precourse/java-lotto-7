package lotto.domain;

public enum CalculationUnit {
    USER_MONEY_PRICE(1000),
    PERCENTAGE(100);

    private final int unit;

    CalculationUnit(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }
}
