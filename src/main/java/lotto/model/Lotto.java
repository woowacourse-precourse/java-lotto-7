package lotto.model;

import static lotto.common.LottoRule.LOTTO_NUMBER_COUNTS;
import static lotto.validator.ValidationMessage.DUPLICATE_NUMBERS;
import static lotto.validator.ValidationMessage.INVALID_NUMBER_COUNTS;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validNumberCounts(numbers);
        validDuplicate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validNumberCounts(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNTS.getValue()) {
            throw new LottoException(INVALID_NUMBER_COUNTS.getMessage());
        }
    }

    private void validDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new LottoException(DUPLICATE_NUMBERS.getMessage());
        }
    }
}
