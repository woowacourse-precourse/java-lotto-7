package lotto.validator;

import static lotto.exception.Exception.*;

import java.util.List;

public class BonusNumberValidator {
    public static void validate(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicate(bonusNumber, winningNumbers);
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateBonusNumberDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }
}
