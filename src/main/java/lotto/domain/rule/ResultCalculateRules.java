package lotto.domain.rule;

public enum ResultCalculateRules {

    DEFAULT_COUNT(0L),
    PERCENTAGE_MULTIPLIER(100.0f),
    ROUNDING_SCALE(100);

    private final Number value;

    ResultCalculateRules(Number value) {
        this.value = value;
    }

    public Number getValue() {
        return value;
    }
}
