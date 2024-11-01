package lotto.domain;

import static lotto.util.ExceptionMessage.INVALID_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.INVALID_RANGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateWinningNumberRange(numbers);
        validateNoDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.format());
        }
    }

    private void validateWinningNumberRange(List<Integer> numbers) {
        boolean isValid = numbers.stream()
                .allMatch(number -> number >= 1
                        && number <= 45);
        if (!isValid) {
            throw new IllegalArgumentException(INVALID_RANGE.format());
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.format());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
