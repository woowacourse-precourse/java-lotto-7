package lotto.util;

import java.util.List;
import lotto.error.ErrorType;
import lotto.error.exception.InvalidNumberException;

public class NumberValidator {

    private NumberValidator() {

    }

    public static NumberValidator getInstance() {
        return BillPughSingleton.INSTANCE;
    }

    public NumberValidator validateRange(final int number, final int min, final int max) {
        if (isExceedsRange(number, min, max)) {
            throw new InvalidNumberException(ErrorType.EXCEEDED_NUMBER_RANGE);
        }
        return this;
    }

    public NumberValidator validateUnit(final int number, final int unit) {
        if (isInvalidUnit(number, unit)) {
            throw new InvalidNumberException(ErrorType.INVALID_MONEY_FORMAT);
        }
        return this;
    }

    public NumberValidator validateContains(final List<Integer> numbers, final int number) {
        if (isContainsNumber(numbers, number)) {
            throw new InvalidNumberException(ErrorType.DUPLICATED_BONUS_NUMBER);
        }
        return this;
    }

    private boolean isExceedsRange(final int number, final int min, final int max) {
        return number < min || number > max;
    }

    private boolean isInvalidUnit(final int number, final int unit) {
        return number % unit != 0;
    }

    private boolean isContainsNumber(final List<Integer> numbers, final int number) {
        return numbers.contains(number);
    }

    private static class BillPughSingleton {
        private static final NumberValidator INSTANCE = new NumberValidator();
    }
}
