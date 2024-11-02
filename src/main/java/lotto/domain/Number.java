package lotto.domain;

import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class Number implements Comparable<Number> {

    private final int value;

    private Number(int value) {
        Validator.validate(value);
        this.value = value;
    }

    public static Number of(int value) {
        return new Number(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Number other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Number other)) {
            return false;
        }
        return this.value == other.value;
    }

    private static class Validator {
        private static void validate(int value) {
            validateRange(value);
        }

        private static void validateRange(int value) {
            if (isInvalidRange(value)) {
                throw new LottoException(ErrorMessage.INVALID_NUMBER_RANGE);
            }
        }

        private static boolean isInvalidRange(int value) {
            return value < 1 || value > 45;
        }
    }
}
