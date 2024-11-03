package lotto.constant;

public enum LottoConstant {
    NUMBER_RANGE_MIN(1),
    NUMBER_RANGE_MAX(45),
    NUMBER_LENGTH(6),
    LOTTO_PRICE(1000),

    INT_ZERO(0);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
