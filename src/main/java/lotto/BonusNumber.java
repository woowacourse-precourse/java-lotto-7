package lotto;

import lotto.util.DuplicateBonusNumberException;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(WinningNumbers winningNumbers) {
        if (winningNumbers.containsBonusNumber(bonusNumber)) {
            throw new DuplicateBonusNumberException();
        }
    }

    public int loadBonusNumber() {
        return bonusNumber;
    }
}
