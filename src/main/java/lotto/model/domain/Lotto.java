package lotto.model.domain;

import static lotto.message.ErrorMessage.INVALID_WINNING_NUMBER_RANGE;
import static lotto.message.ErrorMessage.INVALID_WINNING_NUMBER_SIZE;
import static lotto.message.ErrorMessage.WINNING_NUMBER_DUPLICATES;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_SIZE.getMessage());
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATES.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!isNumbersInRange(numbers)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    private boolean isNumbersInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> num >= 1 && num <= 45);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
