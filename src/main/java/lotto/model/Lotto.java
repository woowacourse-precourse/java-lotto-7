package lotto.model;

import java.util.List;

import static lotto.constant.ErrorMessage.NUMBER_COUNT_ERROR;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_COUNT_ERROR.getMessage());
        }
    }
}
