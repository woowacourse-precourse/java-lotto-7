package lotto.model.bonusnumber;

import lotto.model.ErrorMessage;

import java.util.List;

public class BonusNumberValidator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public String validate(String bonusNumberInput, List<Integer> winningNumbers) {
        if (validateRange(bonusNumberInput)) {
            return ErrorMessage.INVALID_BONUS_NUMBER.getMessage();
        }
        if (validateDuplicate(bonusNumberInput, winningNumbers)) {
            return ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage();
        }
        return bonusNumberInput;
    }

    private boolean validateRange(String bonusNumberInput) {
        try {
            int bonusNumber = Integer.parseInt(bonusNumberInput.trim());
            if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private boolean validateDuplicate(String bonusNumberInput, List<Integer> winningNumbers) {
        try {
            if (winningNumbers.contains(Integer.parseInt(bonusNumberInput))) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }
}
