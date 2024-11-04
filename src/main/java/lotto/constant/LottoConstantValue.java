package lotto.constant;

public enum LottoConstantValue {
    LOTTO_MIN_NUM(1),
    LOTTO_MAX_NUM(45),
    LOTTO_NUMBER_SIZE(6),
    LOTTO_PRICE(1000),
    LOTTO_MAX_PAYMENT(100_000);
    private final int value;

    private LottoConstantValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
