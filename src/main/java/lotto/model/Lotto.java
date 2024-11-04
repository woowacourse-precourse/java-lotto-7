package lotto.model;

import static lotto.enums.ErrorCode.DUPLICATE_LOTTO_NUMBER;
import static lotto.enums.ErrorCode.INVALID_LOTTO_NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumberCount(numbers);
        checkUniqueNumbers(numbers);
    }

    private void checkUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
