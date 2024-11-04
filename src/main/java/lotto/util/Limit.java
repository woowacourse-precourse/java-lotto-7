package lotto.util;

public enum Limit {
    DEFAULT(0),
    LOTTO_NUMBER_COUNT(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    ;

    int value;

    Limit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
