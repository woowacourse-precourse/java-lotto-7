package lotto.model;

import lotto.constants.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
