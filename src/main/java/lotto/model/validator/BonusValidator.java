package lotto.model.validator;

import lotto.exception.Exception;

import java.util.List;

public class BonusValidator extends NumberRangeValidator {
    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateNumberRange(bonusNumber);
        validateBonusNumberDuplication(bonusNumber, winningNumbers);
    }

    private static void validateBonusNumberDuplication(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Exception.DUPLICATE_BONUS_AND_WINNING_NUMBER.getMessage());
        }
    }
}
