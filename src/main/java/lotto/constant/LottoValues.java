package lotto.constant;

public enum LottoValues {
    MONEY_MIN_LIMIT(0),
    MONEY_MAX_LIMIT(2_000_000_000),
    PERCENT_MULTIPLIER(100),
    PRICE(1_000),
    NUMBER_MIN(1),
    NUMBER_MAX(45),
    SIZE(6),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int value;

    LottoValues(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public boolean isEqualTo(int value) {
        return this.value == value;
    }

    public boolean isGreaterThan(int value) {
        return value < this.value;
    }
}
