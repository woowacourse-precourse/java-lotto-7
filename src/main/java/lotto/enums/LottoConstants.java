package lotto.enums;

public enum LottoConstants {
    WINNING_NUMBER_SIZE(6),
    LOTTO_PRICE(1000),
    LOTTO_SIZE(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
