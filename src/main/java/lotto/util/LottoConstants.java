package lotto.util;

public enum LottoConstants {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_LENGTH(6),
    LOTTO_PRICE(1000),
    ZERO_THRESHOLD(0),
    DEFAULT(0);
    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
