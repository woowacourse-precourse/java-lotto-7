package lotto.domain;

import static lotto.exception.ErrorCode.INVALID_LOTTO_LENGTH;
import static lotto.exception.ErrorCode.INVALID_LOTTO_NUMBER_PATTERN;

import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
    }

    private void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(INVALID_LOTTO_LENGTH);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
