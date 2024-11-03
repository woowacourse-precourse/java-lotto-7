package lotto.common.validator;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;
import lotto.error.LottoErrorMessage;

public class DrawnNumbersValidator {
    public static void validate(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (isAlreadyDrawn(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATED_NUMBER
                    .getMessage());
        }
    }

    private static boolean isAlreadyDrawn(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.getNumbers()
                .contains(bonusNumber.getNumber())) {
            return true;
        }
        return false;
    }
}
