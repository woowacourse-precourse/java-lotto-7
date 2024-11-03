package lotto;

import static lotto.constant.ErrorMessage.NOT_NUMBER_RANGE_BONUS_NUMBER;

import lotto.util.DuplicateBonusNumberException;

public class BonusNumber {
    private static final int BONUS_NUMBER_MIN = 1;
    private static final int BONUS_NUMBER_MAX = 45;
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumberInRange() {
        if (bonusNumber < BONUS_NUMBER_MIN || bonusNumber > BONUS_NUMBER_MAX) {
            throw new IllegalArgumentException(NOT_NUMBER_RANGE_BONUS_NUMBER.getMessage());
        }
    }

    public void validateBonusNumberNotDuplicate(WinningNumbers winningNumbers) {

        if (winningNumbers.containsBonusNumber(bonusNumber)) {
            throw new DuplicateBonusNumberException();
        }
    }

    public int loadBonusNumber() {
        return bonusNumber;
    }
}
