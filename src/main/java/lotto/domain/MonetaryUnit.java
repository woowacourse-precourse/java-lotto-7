package lotto.domain;

public enum MonetaryUnit {
    USER_MONEY_PRICE(1000),
    PERCENTAGE(100);

    private final int unit;

    MonetaryUnit(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }
}
