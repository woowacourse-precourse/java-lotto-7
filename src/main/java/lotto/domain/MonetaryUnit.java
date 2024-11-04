package lotto.domain;

public enum MonetaryUnit {
    A_LOTTO_PRICE(1000),
    PERCENTAGE(100);

    private final int unit;

    MonetaryUnit(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }
}
