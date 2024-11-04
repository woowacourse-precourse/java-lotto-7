package lotto.dto;

import lotto.validation.Validator;

public class Buyer {
    private final WinningNumbers winningNumbers;
    private final int bonusNumber;

    public Buyer(WinningNumbers winningNumbers, int bonusNumber) {
        validateNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers getwinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validateNumbers(WinningNumbers winningNumbers, int bonusNumber) {
        Validator.validateNegativeNumber(bonusNumber);
        Validator.validteNumberInRange(bonusNumber);
        Validator.validateDuplicatedBonusNumber(winningNumbers, bonusNumber);
    }
}
