package lotto.model;

import static lotto.common.LottoRule.LOTTO_NUMBER_COUNTS;
import static lotto.validator.ValidationMessage.DUPLICATE_NUMBERS;
import static lotto.validator.ValidationMessage.INVALID_NUMBER_COUNTS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNoDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNTS.getValue()) {
            throw new LottoException(INVALID_NUMBER_COUNTS.getMessage());
        }
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new LottoException(DUPLICATE_NUMBERS.getMessage());
        }
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }
}
