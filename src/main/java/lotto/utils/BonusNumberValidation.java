package lotto.utils;

import lotto.constants.errorType.BonusNumberErrorType;

public class BonusNumberValidation {

    public static int checkedBonusNumber(String rawBonusNumber) {
        validateNumberIsNull(rawBonusNumber);
        int bonusNumber = validateNumberFormat(rawBonusNumber);
        validateNumberRange(bonusNumber);
        return bonusNumber;
    }

    private static void validateNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(BonusNumberErrorType.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private static int validateNumberFormat(String rawBonusNumber) {
        try {
            return Integer.parseInt(rawBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BonusNumberErrorType.INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateNumberIsNull(String rawBonusNumber) {
        if (rawBonusNumber.isBlank()) {
            throw new IllegalArgumentException(BonusNumberErrorType.BONUS_NUMBER_NULL_ERROR.getMessage());
        }
    }

}
