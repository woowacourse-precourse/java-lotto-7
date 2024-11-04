package lotto.model;

public enum LottoConstant {
    MIN_LOTTO_NUMBER(1),
    MAX_VALID_LOTTO_NUMBER(45),
    VALID_LOTTO_NUMBER_COUNT(6),
    PRICE(1000);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
