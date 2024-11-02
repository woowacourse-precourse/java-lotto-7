package lotto.domain.lotto;

import lotto.common.LottoConstants;
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
        checkForDuplicates(numbers);
        checkRange(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void checkForDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LottoErrorMessages.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < LottoConstants.MIN_LOTTO_NUMBER || num > LottoConstants.MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(LottoErrorMessages.OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
