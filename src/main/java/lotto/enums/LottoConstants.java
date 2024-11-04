package lotto.enums;

public enum LottoConstants {
    LOTTO_PRICE(1000),
    LOTTO_NUMBERS_COUNT(6),
    BONUS_NUMBERS_COUNT(1),
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
