package lotto.util;

import java.util.List;
import lotto.error.ErrorType;
import lotto.error.exception.InvalidNumberException;

public class NumberValidator<T extends Number & Comparable<T>> {

    private NumberValidator() {

    }

    public static NumberValidator<Integer> getInstance() {
        return BillPughSingleton.INSTANCE;
    }

    public NumberValidator<T> validateRange(final T number, final T min, final T max) {
        if (isExceedsRange(number, min, max)) {
            throw new InvalidNumberException(ErrorType.EXCEEDED_NUMBER_RANGE);
        }
        return this;
    }

    public NumberValidator<T> validateUnit(final T number, final T unit) {
        if (isInvalidUnit(number, unit)) {
            throw new InvalidNumberException(ErrorType.INVALID_MONEY_FORMAT);
        }
        return this;
    }

    public NumberValidator<T> validateContains(final List<T> numbers, final T number) {
        if (isContainsNumber(numbers, number)) {
            throw new InvalidNumberException(ErrorType.DUPLICATED_BONUS_NUMBER);
        }
        return this;
    }

    private boolean isExceedsRange(final T number, final T min, final T max) {
        return number.compareTo(min) < 0 || number.compareTo(max) > 0;
    }

    private boolean isInvalidUnit(final T number, final T unit) {
        return number.intValue() % unit.intValue() != 0;
    }

    private boolean isContainsNumber(final List<T> numbers, final T number) {
        return numbers.contains(number);
    }

    private static class BillPughSingleton {
        private static final NumberValidator<Integer> INSTANCE = new NumberValidator<>();
    }
}
