package lotto.domain;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.InputException;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw InputException.from(ErrorMessage.LOTTO_SIZE_IS_NOT_VALID);
        }
    }
}
