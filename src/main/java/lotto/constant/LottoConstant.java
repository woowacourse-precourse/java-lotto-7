package lotto.constant;

public enum LottoConstant {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_COUNT(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
