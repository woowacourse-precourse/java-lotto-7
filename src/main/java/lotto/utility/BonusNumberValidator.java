package lotto.utility;

import lotto.enumerate.ExceptionEnum;

public class BonusNumberValidator {
    private static final int MAX_LOTTO_NUMBER = 45;

    public static void validateUnderFourtySix(int bonusNumber) {
        if (bonusNumber > MAX_LOTTO_NUMBER) {
            ExceptionThrower.throwing(ExceptionEnum.CANNOT_OVER_FOURTY_SIX);
        }
    }
}
