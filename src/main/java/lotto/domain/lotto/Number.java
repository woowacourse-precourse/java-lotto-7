package lotto.domain.lotto;

import lotto.global.contents.LottoDetail;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class Number implements Comparable<Number> {

    private final int value;

    protected Number(int value) {
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
        if (o == this) {
            return true;
        }
        if (!(o instanceof Number other)) {
            return false;
        }
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    private static class Validator {
        private static void validate(int value) {
            validateRange(value, LottoDetail.MIN_VALUE, LottoDetail.MAX_VALUE);
        }

        private static void validateRange(int value,
                                          LottoDetail min,
                                          LottoDetail max) {
            if (isInvalidRange(value, min, max)) {
                throw new LottoException(ErrorMessage.INVALID_NUMBER_RANGE);
            }
        }

        private static boolean isInvalidRange(int value,
                                              LottoDetail min,
                                              LottoDetail max) {
            return value < min.getValue() || value > max.getValue();
        }
    }
}
