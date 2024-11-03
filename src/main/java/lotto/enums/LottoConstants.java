package lotto.enums;

public enum LottoConstants {
    LOTTO_PRICE(1000),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45);

    private final int value;

    LottoConstants(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
