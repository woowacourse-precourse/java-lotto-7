package lotto.domain;

import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class BonusNumber {

    private final Number bonusNumber;

    private BonusNumber(WinningNumbers winningNumbers, Number number) {
        Validator.validate(winningNumbers, number);
        this.bonusNumber = number;
    }

    public static BonusNumber valueOf(WinningNumbers winningNumbers, Number number) {
        return new BonusNumber(winningNumbers, number);
    }

    public Number getBonusNumber() {
        return bonusNumber;
    }

    private static class Validator {
        private static void validate(WinningNumbers winningNumbers, Number number) {
            if (isBonusNumberInWinningNumbers(winningNumbers, number)) {
                throw new LottoException(ErrorMessage.INVALID_BONUS_NUMBER);
            }
        }

        private static boolean isBonusNumberInWinningNumbers(WinningNumbers winningNumbers,
                                                             Number number) {
            return winningNumbers.contains(number);
        }
    }
}
