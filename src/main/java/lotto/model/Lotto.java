package lotto.model;

import static lotto.Constant.MAX_NUMBER;
import static lotto.Constant.MIN_NUMBER;
import static lotto.Constant.NUMBER_COUNT;
import static lotto.exception.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.exception.ErrorMessage.INVALID_NUMBER_COUNT;
import static lotto.exception.ErrorMessage.OUT_OF_RANGE_NUMBER;

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
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER.getMessage());
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    public int countSameNumber(Lotto lotto) {
        int result = 0;
        for (Integer number : numbers) {
            if(lotto.getNumbers().contains(number)) {
                result++;
            }
        }
        return result;
    }

    public boolean hasNumber(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
