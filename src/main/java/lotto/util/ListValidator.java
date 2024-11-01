package lotto.util;

import java.util.List;
import lotto.error.ErrorType;
import lotto.error.exception.InvalidNumbersException;

public class ListValidator {

    private ListValidator() {

    }

    public static ListValidator getInstance() {
        return BillPughSingleton.INSTANCE;
    }

    public ListValidator validateSize(final List<Integer> numbers, final int size) {
        if (isInvalidNumbersSize(numbers, size)) {
            throw new InvalidNumbersException(ErrorType.INVALID_WINNING_NUMBER_SIZE);
        }
        return this;
    }

    public ListValidator validateDuplicate(final List<Integer> numbers) {
        if (isDuplicateNumbers(numbers)) {
            throw new InvalidNumbersException(ErrorType.DUPLICATED_WINNING_NUMBERS);
        }
        return this;
    }

    public ListValidator validateRange(final List<Integer> numbers, final ValidateFunction validateFunction) {
        for (Integer number : numbers) {
            validateFunction.validate(number);
        }
        return this;
    }

    @FunctionalInterface
    public interface ValidateFunction {
        void validate(final int number);
    }

    private boolean isInvalidNumbersSize(final List<Integer> numbers, final int size) {
        return numbers.size() != size;
    }

    private boolean isDuplicateNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }


    private static class BillPughSingleton {
        private static final ListValidator INSTANCE = new ListValidator();
    }
}
