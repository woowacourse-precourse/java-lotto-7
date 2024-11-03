package lotto.model;

import static lotto.constant.Constants.LOTTO_NUMBER_LENGTH;
import static lotto.constant.Constants.LOTTO_NUMBER_RANGE_END;
import static lotto.constant.Constants.LOTTO_NUMBER_RANGE_START;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.InputNumberException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(InputNumberException.INVALID_LENGTH.getMessage());
        }

        for (int number : numbers) {
            if (number < LOTTO_NUMBER_RANGE_START || number > LOTTO_NUMBER_RANGE_END) {
                throw new IllegalArgumentException(InputNumberException.INVALID_RANGE.getMessage());
            }
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(InputNumberException.DUPLICATE_NUMBERS.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
