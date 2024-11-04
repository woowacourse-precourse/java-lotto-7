package lotto.domain;

import java.util.List;
import lotto.exception.LottoException;
import lotto.exception.message.LottoExceptionMessage;

import static lotto.constant.LottoConstant.*;

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
        validateNumbersSizeIsLottoCount(numbers);
        validateNumbersInRange(numbers);
        validateDuplicated(numbers);
    }

    private void validateNumbersSizeIsLottoCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_TO_DRAW) {
            throw new LottoException(LottoExceptionMessage.INVALID_LOTTO_COUNT);
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                throw new LottoException(LottoExceptionMessage.INVALID_LOTTO_NUMBER);
            }
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new LottoException(LottoExceptionMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }


}
