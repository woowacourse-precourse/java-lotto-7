package lotto.domain;

import lotto.common.validator.DrawnNumbersValidator;

public class DrawnNumbers {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public DrawnNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        DrawnNumbersValidator.validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
