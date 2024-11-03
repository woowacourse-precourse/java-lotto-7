package lotto.model;

import lotto.utils.BonusNumberValidator;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(int bonusNumber,WinningNumbers winningNumbers) {
        BonusNumberValidator.validateBonusNumber(String.valueOf(bonusNumber),winningNumbers.getWinningNumbers());
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(int bonusNumber,WinningNumbers winningNumbers) {
        return new BonusNumber(bonusNumber,winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
