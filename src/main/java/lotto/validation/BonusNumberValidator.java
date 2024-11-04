package lotto.validation;

import java.util.List;
import lotto.exception.ErrorMessage;

public class BonusNumberValidator extends BaseValidator{

    public static void validateOnlyNumeric(String input) {
        if (!hasOnlyDigits(input)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NUMBER_NOT_NUMERIC.toString());
        }
    }

    public static void validateNumberRange(int bonusNumber) {
        if (bonusNumber<1 || bonusNumber > 45){
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_RANGE.toString());
        }
    }

    public static void validateBonusNumberDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        for (int winningNumber:winningNumbers){
            validateDuplicate(bonusNumber, winningNumber);
        }
    }

    private static void validateDuplicate(int bonusNumber, int winningNumber) {
        if (winningNumber==bonusNumber){
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NUMBER_DUPLICATE.toString());
        }
    }

    private static boolean hasOnlyDigits(final String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }
}
