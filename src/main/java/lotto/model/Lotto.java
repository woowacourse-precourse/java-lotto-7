package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import lotto.exception.ErrorMessage;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;

    private final List<Integer> numbers;

    protected Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);
        validateOutOfRangeNumbers(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int countMatches(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::isContains)
                .count();
    }

    public boolean isDuplicateBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private boolean isContains(Integer number) {
        return this.numbers.contains(number);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_SIZE.getErrorMessage());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        HashSet<Integer> nonDuplicateNumbersSet = new HashSet<>(numbers);
        if (nonDuplicateNumbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getErrorMessage());
        }
    }

    private void validateOutOfRangeNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getErrorMessage());
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
