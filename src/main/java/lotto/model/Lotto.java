package lotto.model;

import static lotto.model.LottoConstants.INVALID_NUMBER_RANGE_ERROR_MESSAGE;
import static lotto.model.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.model.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.model.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.model.LottoErrorConstants.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static lotto.model.LottoErrorConstants.INVALID_NUMBER_COUNT_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = new ArrayList<>(numbers);
        numbers.sort(null);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        HashSet<Integer> duplicateChecker = new HashSet<>(numbers);
        if (duplicateChecker.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
