package lotto.utils;

import lotto.constants.errorType.BonusNumberErrorType;
import lotto.constants.lottoType.LottoType;

import java.util.List;

public class BonusNumberValidation {

    public static int checkedBonusNumber(String rawBonusNumber) {
        validateNumberIsNull(rawBonusNumber);
        int bonusNumber = validateNumberFormat(rawBonusNumber);
        validateNumberRange(bonusNumber);
        return bonusNumber;
    }

    private static void validateNumberRange(int bonusNumber) {
        if (bonusNumber < LottoType.LOTTO_MIN_NUMBER.getValue() || bonusNumber > LottoType.LOTTO_MAX_NUMBER.getValue()) {
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

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BonusNumberErrorType.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

}
