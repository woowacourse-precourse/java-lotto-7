package lotto;

import java.util.List;

public class LottoListValidator {

    public void validateSize(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicate(final List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateRange(final List<Integer> numbers, final ValidateFunction validateFunction) {
        for (Integer number : numbers) {
            validateFunction.validate(number);
        }
    }

    private boolean isDuplicate(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    @FunctionalInterface
    public interface ValidateFunction {
        void validate(final int number);
    }
}
