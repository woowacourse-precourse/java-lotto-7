package lotto.constant;

public enum LottoConstant {
    LOTTO_NUMBER_RANGE_MIN(1),
    LOTTO_NUMBER_RANGE_MAX(45),
    LOTTO_NUMBER_COUNT(6),
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
