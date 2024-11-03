package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.WinningNumberException;

public record WinningNumbers(Lotto mainNumbers, Integer bonusNumber) {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public WinningNumbers {
        validate(mainNumbers, bonusNumber);
    }

    private void validate(Lotto mainNumbers, Integer bonusNumber) {
        if (mainNumbers == null) {
            throw new WinningNumberException(ErrorMessages.MAIN_NUMBERS_NULL);
        }
        if (bonusNumber == null) {
            throw new WinningNumberException(ErrorMessages.BONUS_NUMBER_NULL);
        }
        if (mainNumbers.containsNumber(bonusNumber)) {
            throw new WinningNumberException(ErrorMessages.BONUS_NUMBER_DUPLICATE);
        }
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new WinningNumberException(ErrorMessages.BONUS_NUMBER_RANGE);
        }
    }
}
