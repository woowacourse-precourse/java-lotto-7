package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    NOT_SIX_LOTTO_NUMBERS.getMessage());
        }
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException(
                    OUT_OF_RANGE_LOTTO_NUMBERS.getMessage());
        }
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(
                    DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_NUMBER.getValue()
                    || number > MAX_LOTTO_NUMBER.getValue()) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
