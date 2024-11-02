package lotto.model;

import lotto.Message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_COUNT.toString());
        }
    }

    private void validDuplicates(List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATES.toString());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_RANGE.toString());
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() < numbers.size();
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatches(Lotto winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    public boolean isBonusMatched(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
