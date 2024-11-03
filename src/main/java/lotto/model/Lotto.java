package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoConstants;
import lotto.exception.InputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoConstants.ERROR_INVALID_LOTTO_NUMBER_COUNT);
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new InputException(LottoConstants.ERROR_DUPLICATE_LOTTO_NUMBER);
        }
    }

    public void sortAscendingInteger() {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
