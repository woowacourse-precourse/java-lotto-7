package lotto.util;

import java.util.List;
import lotto.error.ErrorMessage;
import lotto.error.exception.InvalidNumbersException;

public class ListValidator<T> {

    private ListValidator() {

    }

    public static ListValidator<Integer> getInstance() {
        return BillPughSingleton.INSTANCE;
    }

    public ListValidator<T> validateSize(final List<T> values, final int size) {
        if (isInvalidNumbersSize(values, size)) {
            throw new InvalidNumbersException(ErrorMessage.INVALID_WINNING_NUMBER_SIZE);
        }
        return this;
    }

    public ListValidator<T> validateDuplicate(final List<T> values) {
        if (isDuplicate(values)) {
            throw new InvalidNumbersException(ErrorMessage.DUPLICATED_WINNING_NUMBERS);
        }
        return this;
    }

    public ListValidator<T> validateRange(final List<T> values, final ValidateFunction<T> validateFunction) {
        for (T value : values) {
            validateFunction.validate(value);
        }
        return this;
    }


    private boolean isInvalidNumbersSize(final List<T> values, final int size) {
        return values.size() != size;
    }

    private boolean isDuplicate(final List<T> values) {
        return values.stream()
                .distinct()
                .count() != values.size();
    }


    private static class BillPughSingleton {
        private static final ListValidator<Integer> INSTANCE = new ListValidator<>();
    }
}
