package lotto;

import static lotto.Model.ErrorCode.*;
import static lotto.constants.Constants.LOTTO_MAX_VALUE;
import static lotto.constants.Constants.LOTTO_MIN_VALUE;
import static lotto.constants.Constants.LOTTO_NUMBER_LENGTH;

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
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        hasDuplicate(numbers);
        validateNumberRange(numbers);
    }

    private void hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(num -> num < LOTTO_MIN_VALUE || num > LOTTO_MAX_VALUE)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
