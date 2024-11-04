package lotto.validation;

import lotto.constants.ErrorMessageConstants;
import lotto.constants.LottoConstants;

import java.util.List;

public class BonusNumberValidator {
    private BonusNumberValidator() {
        throw new IllegalStateException(ErrorMessageConstants.INSTANCE_CREATION_ERROR);
    }

    public static void validateBonusNumberInput(String bonusNumberInput) {
        ValidationUtils.validateNotBlank(bonusNumberInput, ErrorMessageConstants.EMPTY_BONUS_NUMBER);
        ValidationUtils.validateIsNumber(bonusNumberInput, ErrorMessageConstants.INVALID_BONUS_NUMBER_FORMAT);
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicate(winningNumbers, bonusNumber);
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LottoConstants.LOTTO_MIN_NUMBER || bonusNumber > LottoConstants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_BONUS_NUMBER_RANGE);
        }
    }

    private static void validateBonusNumberDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_BONUS_NUMBER_DUPLICATE);
        }
    }
}
