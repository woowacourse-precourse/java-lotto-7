package lotto.domain;

public enum MonetaryUnit {
    USER_MONEY_PRICE(1000),
    PERCENTAGE(100),
    ROUND_UP_TO_TWO_DECIMAL_PLACES(10);

    private final int unit;

    MonetaryUnit(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }
}
