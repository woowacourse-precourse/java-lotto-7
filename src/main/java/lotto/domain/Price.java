package lotto.domain;

public class Price {

    private static final int PRICE_UNIT = 1_000;

    private final int value;

    private Price(int value) {
        this.value = value;
    }

    public static Price from(int value) {
        return new Price(value);
    }

    public int getValue() {
        return value;
    }

    public int getCount() {
        return value / PRICE_UNIT;
    }
}
