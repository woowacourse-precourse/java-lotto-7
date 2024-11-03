package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.LottoException;

public record WinningNumbers(Lotto mainNumbers, Integer bonusNumber) {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public WinningNumbers {
        validate(mainNumbers, bonusNumber);
    }

    private void validate(Lotto mainNumbers, Integer bonusNumber) {
        if (mainNumbers == null) {
            throw new LottoException(ErrorMessages.MAIN_NUMBERS_NULL);
        }
        if (bonusNumber == null) {
            throw new LottoException(ErrorMessages.BONUS_NUMBER_NULL);
        }
        if (mainNumbers.containsNumber(bonusNumber)) {
            throw new LottoException(ErrorMessages.BONUS_NUMBER_DUPLICATE);
        }
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new LottoException(ErrorMessages.BONUS_NUMBER_RANGE);
        }
    }
}
