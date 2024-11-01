package lotto.domain;

import static lotto.util.ExceptionMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.util.ExceptionMessage.INVALID_RANGE;

import static lotto.util.Constants.MIN_LOTTO_NUMBER;
import static lotto.util.Constants.MAX_LOTTO_NUMBER;

import java.util.List;

public class BonusBall {
    private final int number;

    public BonusBall (int number, List<Integer> winningNumbers) {
        validateNumberRange(number);
        validateNoDuplicateWithWinningNumbers(number, winningNumbers);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER.getIntValue() || number > MAX_LOTTO_NUMBER.getIntValue()) {
            throw new IllegalArgumentException(INVALID_RANGE.format());
        }
    }

    private void validateNoDuplicateWithWinningNumbers(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.format());
        }
    }

    public int getBonusNumber() {
        return number;
    }
}