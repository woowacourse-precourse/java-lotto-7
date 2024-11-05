package lotto.model;

import lotto.exception.InvalidLottoDuplicateException;
import lotto.exception.InvalidLottoRangeException;
import lotto.exception.LottoNotSixException;

import java.util.List;

import static lotto.constant.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new LottoNotSixException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_START || number > LOTTO_END) {
                throw new InvalidLottoRangeException();
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_COUNT) {
            throw new InvalidLottoDuplicateException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
