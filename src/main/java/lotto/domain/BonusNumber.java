package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.constants.LottoConstants.LOTTO_MIN_NUMBER;

import lotto.constants.ErrorMessages;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, WinningNumbers winningNumbers) {
        validateBonusNumber(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, WinningNumbers winningNumbers) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
        }
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_DUPLICATE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
