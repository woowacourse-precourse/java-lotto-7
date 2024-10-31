package lotto.domain;

import java.util.List;
import lotto.ExceptionMessage;
import lotto.Validator;

public class Lotto {

    private final List<Integer> numbers;
    public static final int NUMBER_SIZE = 6;
    public static final int NUMBER_BEGIN_RANGE = 1;
    public static final int NUMBER_END_RANGE = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validator.validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_COUNT_EXCEPTION.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
