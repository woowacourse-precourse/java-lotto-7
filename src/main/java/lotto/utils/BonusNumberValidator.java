package lotto.utils;

import java.util.List;

public class BonusNumberValidator {

    public static void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        validateIsNumeric(bonusNumber);
        validateInRange(bonusNumber);
        validateNotDuplicateWithWinningNumbers(bonusNumber, winningNumbers);
    }

    private static void validateIsNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    private static void validateInRange(String number) {
        int num = Integer.parseInt(number);
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateNotDuplicateWithWinningNumbers(String number, List<Integer> winningNumbers) {
        int bonusNum = Integer.parseInt(number);
        if (winningNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_DUPLICATE.getMessage());
        }
    }
}
