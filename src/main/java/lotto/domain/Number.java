package lotto.domain;

import lotto.exception.number.NumberOutOfRangeException;

final public class Number {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    private final int value;

    public Number(int value) {
        validateValueInRange(value);
        this.value = value;
    }

    private static void validateValueInRange(int value) {
        if (value < MIN_VALUE || MAX_VALUE < value) {
            throw new NumberOutOfRangeException(MIN_VALUE, MAX_VALUE);
        }
    }
}
