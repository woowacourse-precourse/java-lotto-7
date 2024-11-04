package lotto.model;

import lotto.enums.ErrorCode;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }

        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
