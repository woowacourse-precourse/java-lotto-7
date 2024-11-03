package lotto.model;

import lotto.util.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_COUNT.getMessage());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }
}