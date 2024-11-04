package lotto.validate;

public enum LottoConstants {
    LOTTO_PRICE(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    MIN_VALID_AMOUNT(1),
    ZERO_VALID_AMOUNT(0);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
