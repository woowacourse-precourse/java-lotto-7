package lotto.model;

import lotto.utils.Constants;
import lotto.utils.ErrorMessages;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number, Lotto winningNumbers) {
        validate(number, winningNumbers);
        this.number = number;
    }

    private void validate(int number, Lotto winningNumbers) {
        validateNumberRange(number);
        validateNotDuplicatedWithWinningNumbers(number, winningNumbers);
    }

    private void validateNotDuplicatedWithWinningNumbers(int number, Lotto winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_LOTTO_NUMBER);   //TODO
        }
    }

    private void validateNumberRange(int number) {
        if (number < Constants.LOTTO_MIN_NUMBER || number > Constants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    public int getNumber() {
        return number;
    }
}
