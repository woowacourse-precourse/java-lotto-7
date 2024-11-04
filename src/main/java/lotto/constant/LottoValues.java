package lotto.constant;

public enum LottoValues {
    LOTTO_MONEY_MIN_LIMIT(0),
    LOTTO_MONEY_MAX_LIMIT(2_000_000_000),
    PERCENT_MULTIPLIER(100),
    LOTTO_PRICE(1_000),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_SIZE(6),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int value;

    LottoValues(int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }
}
