package lotto.domain.model.lotto;

import lotto.domain.constant.GlobalConstants;
import lotto.exception.lotto.LottoErrorMessages;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkNotDuplicate(numbers);
        checkRange(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != GlobalConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void checkNotDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LottoErrorMessages.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < GlobalConstants.MIN_LOTTO_NUMBER || num > GlobalConstants.MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(LottoErrorMessages.OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
