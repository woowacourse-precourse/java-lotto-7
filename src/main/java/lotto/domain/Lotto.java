package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.ErrorMessages;
import lotto.constants.LottoConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_COUNT);
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_LOTTO_NUMBER);
        }
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(int number) {
        if (number < LottoConstants.LOTTO_MIN_NUMBER || number > LottoConstants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount(Set<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
