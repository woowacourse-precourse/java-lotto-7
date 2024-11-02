package lotto.util;

import static lotto.util.Constants.ERROR_BONUS_NUMBER;
import static lotto.util.Constants.ERROR_START;

public class BonusNumberValidator {

    private int bonusNumber;

    public int validate(String number) {
        validateNumber(number);
        validateRange();
        return bonusNumber;
    }

    private void validateNumber(String number) {
        try {
            bonusNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_START.getMessage() + ERROR_BONUS_NUMBER.getMessage());
        }
    }

    private void validateRange() {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_START.getMessage() + ERROR_BONUS_NUMBER.getMessage());
        }
    }
}