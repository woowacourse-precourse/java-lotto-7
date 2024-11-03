package lotto.model;

import java.util.HashSet;
import java.util.List;
import lotto.utils.Constants;
import lotto.utils.ErrorMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateNumberRange(numbers);
        validateUniqueness(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_LENGTH_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean isInvalidRange = numbers.stream()
                .anyMatch(n -> n < Constants.LOTTO_MIN_NUMBER || n > Constants.LOTTO_MAX_NUMBER);
        if (isInvalidRange) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_RANGE_MESSAGE);
        }
    }

    private void validateUniqueness(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_DUPLICATE_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
