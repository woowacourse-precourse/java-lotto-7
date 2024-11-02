package lotto.domain;

import lotto.exception.ExceptionMessages;

public class WinningInfo {
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningInfo(Lotto winningNumbers, BonusNumber bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningNumbers, BonusNumber bonusNumber) {
        int number = bonusNumber.getBonusNumber();
        if (winningNumbers.isLottoContainThisNumber(number)) {
            throw new IllegalArgumentException(ExceptionMessages.NUMBER_ALREADY_EXIST.getMessage());
        }
    }
}
