package lotto.domain.model;

import lotto.util.ErrorMessages;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
    private static final int REQUIRED_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_COUNT);
        }
        if (numbers.stream().anyMatch(num -> num < MIN_NUMBER || num > MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_RANGE);
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_WINNING_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}