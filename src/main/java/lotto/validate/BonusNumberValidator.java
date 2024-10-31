package lotto.validate;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;

public class BonusNumberValidator {

    public static void validateBonusNumber(String bonusNumber) throws IllegalArgumentException {
        validateBonusNumberType(bonusNumber);
        validateBonusNumberRange(Integer.parseInt(bonusNumber));
    }

    private static void validateBonusNumberRange(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < LottoConstants.LOTTO_START_INCLUSIVE
                || bonusNumber > LottoConstants.LOTTO_END_INCLUSIVE) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private static void validateBonusNumberType(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_TYPE.getMessage());
        }
    }
}
