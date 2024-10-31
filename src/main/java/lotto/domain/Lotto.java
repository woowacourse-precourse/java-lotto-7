package lotto.domain;

import java.util.List;

import static lotto.constants.LottoErrorMessage.INVALID_NUMBER_COUNT;
import static lotto.constants.LottoErrorMessage.NUMBER_OUT_OF_RANGE;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private void validateInRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
            }
        });
    }
}
