package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessages;
import lotto.constant.LottoConstants;
import lotto.exception.InputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateUniqueNumbers(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new InputException(ErrorMessages.ERROR_DUPLICATE_LOTTO_NUMBER);
        }
    }

    public void sortAscendingInteger() {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
