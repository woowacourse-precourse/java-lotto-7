package lotto.constant;

public enum LottoConstants {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    VALID_SIZE(6),
    PRICE(1_000);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
