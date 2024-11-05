package lotto.utility;

import lotto.constants.Constants;
import lotto.enumerate.ExceptionEnum;

public class BonusNumberValidator {
    public static void validateUnderFourtySix(int bonusNumber) {
        if (bonusNumber > Constants.MAX_LOTTO_NUMBER) {
            ExceptionThrower.throwing(ExceptionEnum.CANNOT_OVER_FOURTY_SIX);
        }
    }
}
