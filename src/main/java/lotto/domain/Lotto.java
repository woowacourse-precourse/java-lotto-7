package lotto.domain;

import java.util.List;

import static lotto.exception.ErrorMessages.*;
import static lotto.util.Validator.areAllNumbersInRange1To45;
import static lotto.util.Validator.isDuplicate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isSizeSix(numbers.size())) {
            throw new IllegalArgumentException(LOTTO_NUMBER_LENGTH_ERROR);
        }

        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR);
        }

        if (!areAllNumbersInRange1To45(numbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    public boolean contains(int target) {
        return numbers.stream()
                .anyMatch(number -> number.equals(target));
    }

    private boolean isSizeSix(int size) {
        return size == 6;
    }
}
