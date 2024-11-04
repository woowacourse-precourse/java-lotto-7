package lotto.domain;

import static lotto.enums.Constants.LOTTO_NUMBER_COUNT;
import static lotto.enums.Constants.LOTTO_NUMBER_MAXIMUM;
import static lotto.enums.Constants.LOTTO_NUMBER_MINIMUM;
import static lotto.enums.ExceptionMessage.LOTTO_NUMBER_COUNT_EXCEPTION;
import static lotto.enums.ExceptionMessage.LOTTO_NUMBER_DUPLICATE_EXCEPTION;
import static lotto.enums.ExceptionMessage.LOTTO_NUMBER_RANGE_EXCEPTION;

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
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_EXCEPTION.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(number -> number < LOTTO_NUMBER_MINIMUM.getValue() ||
                        number > LOTTO_NUMBER_MAXIMUM.getValue());
        if (isOutOfRange) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}