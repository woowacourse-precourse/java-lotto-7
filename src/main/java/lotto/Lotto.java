package lotto;

import static lotto.eunm.LottoConstants.*;
import static lotto.vaildate.ErrorMessage.INVALID_NUMBER_COUNT;

import java.util.List;
import lotto.vaildate.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUniqueNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT);
        }
    }

    private void validateUniqueNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_COUNT.value) {
            throw new IllegalArgumentException(ErrorMessage.UNIQUE_NUMBER);
        }
    }

}
