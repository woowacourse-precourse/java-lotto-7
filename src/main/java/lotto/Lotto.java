package lotto;

import lotto.exception.InvalidNumberException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.exception.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidNumberException(INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream().
                filter(number -> number < 1 || number > 45)
                .findAny()
                .ifPresent(number -> {
                    throw new InvalidNumberException(INVALID_NUMBER_RANGE.getMessage());
                });
    }

    public static void validateDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()) {
            throw new InvalidNumberException(INVALID_NUMBER_DUPLICATE.getMessage());
        }
    }

    public List<Integer> numbers() {
        return this.numbers;
    }
}
