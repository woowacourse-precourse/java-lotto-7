package lotto.model;

import lotto.Exception.LottoException;

import java.util.List;

import static lotto.Exception.LottoExceptionType.*;
import static lotto.utils.LottoRules.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new LottoException(LOTTO_NUMBER_EMPTY_ERROR);
        }
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new LottoException(LOTTO_NUMBER_COUNT_ERROR);
        }
        if (isDuplicateNumbers(numbers)) {
            throw new LottoException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
        if (!isValidRangeNumbers(numbers)) {
            throw new LottoException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    private boolean isDuplicateNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean isValidRangeNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                return false;
            }
        }
        return true;
    }
}
