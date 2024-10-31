package lotto;

import java.util.List;

public class LottoListValidator {

    public LottoListValidator validateSize(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public LottoListValidator validateDuplicate(final List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public LottoListValidator validateRange(final List<Integer> numbers, final ValidateFunction validateFunction) {
        for (Integer number : numbers) {
            validateFunction.validate(number);
        }
        return this;
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
