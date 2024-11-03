package lotto.model;

import java.util.List;
import lotto.util.Validator;

public class Lotto {

    public static final int LOTTO_NUMBER_MINIMUM = 1;

    public static final int LOTTO_NUMBER_MAXIMUM = 45;

    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.isEqualListSize(numbers, LOTTO_NUMBER_COUNT);
        Validator.isNotDuplicate(numbers);
        numbers.forEach(number -> {
            Validator.isNumberWithinRange(number, LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM);
        });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
