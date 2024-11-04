package lotto.domain.winning;

import lotto.domain.lotto.Number;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class BonusNumber extends Number {

    private BonusNumber(int number) {
        super(number);
    }

    public static BonusNumber valueOf(WinningLotto winningLotto,
                                      int number) {
        Validator.validate(winningLotto, number);
        return new BonusNumber(number);
    }

    private static class Validator {
        private static void validate(WinningLotto winningLotto,
                                     int number) {
            if (isBonusNumberInWinningNumbers(winningLotto, number)) {
                throw new LottoException(ErrorMessage.INVALID_BONUS_NUMBER);
            }
        }

        private static boolean isBonusNumberInWinningNumbers(
                WinningLotto winningLotto, int number) {
            return winningLotto.contains(number);
        }
    }
}
