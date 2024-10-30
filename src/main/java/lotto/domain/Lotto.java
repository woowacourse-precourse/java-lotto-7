package lotto.domain;

import java.util.List;
import lotto.ExceptionMessage;
import lotto.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validator.validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_COUNT_EXCEPTION.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
