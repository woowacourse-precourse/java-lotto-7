package lotto.vo;

import lotto.constant.ErrorMessage;

public record BonusNumber(LottoNumber bonusNumber) {
    public BonusNumber(LottoNumber bonusNumber, WinningNumber winningNumber) {
        this(bonusNumber);
        validateBonusNumber(bonusNumber, winningNumber);
    }

    public int getBonusNumber() {
        return bonusNumber.value();
    }

    private static void validateBonusNumber(LottoNumber bonusNumber, WinningNumber winningNumber) {
        if (isDuplicateBonusInWinning(bonusNumber, winningNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATION_ERROR);
        }
    }

    private static boolean isDuplicateBonusInWinning(LottoNumber bonusNumber, WinningNumber winningNumber) {
        return winningNumber.contains(bonusNumber);
    }
}