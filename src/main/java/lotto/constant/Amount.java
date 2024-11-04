package lotto.constant;

public enum Amount {

    THOUSAND(1000),
    ZERO(0),
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    EMPTY_VALUE(0),
    MATCHED_ZERO(0),
    PLUS_MATCHED_COUNT(1),
    INITIAL_VALUE(0),
    SINGLE_DIGIT(1),
    LOTTO_NUMBERS_SIZE(6);

    private final int value;

    private Amount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
