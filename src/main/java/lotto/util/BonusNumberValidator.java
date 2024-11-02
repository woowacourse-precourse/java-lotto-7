package lotto.util;

import java.util.List;

import static lotto.util.Constants.*;

public class BonusNumberValidator {

    private int bonusNumber;

    public int validate(String number, List<Integer> winningNumbers) {
        validateNumber(number);
        validateRange();
        validateDuplicate(winningNumbers);
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

    private void validateDuplicate(List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_START.getMessage() + ERROR_DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}