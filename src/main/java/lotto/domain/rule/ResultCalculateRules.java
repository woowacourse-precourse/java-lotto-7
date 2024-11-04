package lotto.domain.rule;

public enum ResultCalculateRules {

    PERCENTAGE_MULTIPLIER(100.0f),
    ROUNDING_SCALE(100),
    DEFAULT_COUNT(0L),
    ZERO_LOTTO_PRICE(0);

    private final Number value;

    ResultCalculateRules(Number value) {
        this.value = value;
    }

    public Number getValue() {
        return value;
    }
}
