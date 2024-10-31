package lotto.domain.constants.value;

public enum LottoRule {
    COMBINATION_LENGTH(6),
    MINIMUM_NUMBER_RANGE(1),
    MAXIMUM_NUMBER_RANGE(45);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
