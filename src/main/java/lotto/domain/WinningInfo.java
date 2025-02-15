package lotto.domain;

import lotto.exception.ExceptionMessages;

public class WinningInfo {

    private static final int TRUE_VAL = 1;
    private static final int FALSE_VAL = 0;

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

    public int isWinningNumbersContainThisNumber(int number) {
        if (winningNumbers.isLottoContainThisNumber(number)) {
            return TRUE_VAL;
        }
        return FALSE_VAL;
    }

    public int isBonusNumberSameAsThis(int number) {
        if (bonusNumber.compareNumber(number)) {
            return TRUE_VAL;
        }
        return FALSE_VAL;
    }
}
