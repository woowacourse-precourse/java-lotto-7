package lotto.domain;

import lotto.utils.BonusNumberValidator;

public class BonusNumber {
    private final String bonusNumber;

    private BonusNumber(String bonusNumber,WinningNumbers winningNumbers) {
        BonusNumberValidator.validateBonusNumber(String.valueOf(bonusNumber),winningNumbers.getWinningNumbers());
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(String bonusNumber,WinningNumbers winningNumbers) {
        return new BonusNumber(bonusNumber,winningNumbers);
    }

    public String getBonusNumber() {
        return bonusNumber;
    }
}
