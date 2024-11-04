package lotto.util;

import lotto.constant.ExceptionMessage;
import lotto.constant.GameConfig;

public class BonusNumberValidation {

    public static void validateBonusNumber(String bonusNumber){
        validateBonusNumberFormat(bonusNumber);
    }

    private static void validateBonusNumberFormat(String bonusNumber) {
        if (!bonusNumber.matches(GameConfig.VALID_BONUS_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT_ERROR);
        }
    }


}
