package lotto.constant;

public enum LottoConstant {
    MIN_LOTTO_NUMBER_RANGE(1),
    MAX_LOTTO_NUMBER_RANGE(45),
    NUMBER_COUNT(6),
    PURCHASE_AMOUNT(1_000),
    PURCHASE_LIMIT_AMOUNT(100_000);
    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
