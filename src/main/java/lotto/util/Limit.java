package lotto.util;

public enum Limit {
    DEFAULT(0),
    LOTTO_NUMBER_COUNT(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    UNIT_PRICE(1000),
    MIN_AMOUNT(1000),
    MAX_AMOUNT(100000),
    INCREASE_UNIT(1),
    PERCENT(100),
    TEN(10),
    ;

    int value;

    Limit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
