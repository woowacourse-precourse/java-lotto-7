package lotto.model;

import lotto.constant.ErrorMessage;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    ErrorMessage.NOT_SIX_LOTTO_NUMBERS.getMessage());
        }
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(
                    ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
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

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
