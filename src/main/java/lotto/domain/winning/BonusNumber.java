package lotto.domain.winning;

import lotto.domain.number.Number;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class BonusNumber {

    private final Number bonusNumber;

    private BonusNumber(WinningLotto winningLotto, Number number) {
        Validator.validate(winningLotto, number);
        this.bonusNumber = number;
    }

    public static BonusNumber valueOf(WinningLotto winningLotto,
                                      Number number) {
        return new BonusNumber(winningLotto, number);
    }

    public Number getBonusNumber() {
        return bonusNumber;
    }

    private static class Validator {
        private static void validate(WinningLotto winningLotto,
                                     Number number) {
            if (isBonusNumberInWinningNumbers(winningLotto, number)) {
                throw new LottoException(ErrorMessage.INVALID_BONUS_NUMBER);
            }
        }

        private static boolean isBonusNumberInWinningNumbers(
                WinningLotto winningLotto, Number number) {
            return winningLotto.contains(number);
        }
    }
}
