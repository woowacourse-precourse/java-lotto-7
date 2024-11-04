package lotto;

import java.util.Collections;
import java.util.List;

import static lotto.validator.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateRanges(numbers);
        validateDuplicatedNumber(numbers);
    }

    public static void validateNumberCount(List<Integer> tokens) {
        if (tokens.size() != 6) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + NUMBER_COUNT.getMessage());
        }
    }

    private void validateRanges(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + RANGE.getMessage());
        }
    }

    public static void validateDuplicatedNumber(List<Integer> numbers) {
        boolean hasDuplicates = numbers.stream()
                .anyMatch(number -> Collections.frequency(numbers, number) > 1);

        if (hasDuplicates) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
