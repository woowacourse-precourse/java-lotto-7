package lotto.model;

import lotto.enums.ExceptionMessage;
import lotto.enums.LottoValue;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        this.numbers = sorted;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoValue.SIZE.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER.getMessage());
        }
    }
}
