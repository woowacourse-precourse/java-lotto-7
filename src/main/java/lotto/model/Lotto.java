package lotto.model;

import lotto.validation.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getMessage());
        }
        validateDuplicate(numbers);
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicate = new HashSet<>(numbers);
        if (checkDuplicate.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }
}
