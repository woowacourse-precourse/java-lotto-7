package lotto;

import java.util.List;

public class BonusNumberValidator {

    private static final String INVALID_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATE_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public String validate(String bonusNumberInput, List<Integer> winningNumbers) {
        if (validateRange(bonusNumberInput)) {
            return INVALID_BONUS_NUMBER_ERROR;
        }
        if (validateDuplicate(bonusNumberInput, winningNumbers)) {
            return DUPLICATE_BONUS_NUMBER_ERROR;
        }
        return bonusNumberInput;
    }

    private boolean validateRange(String bonusNumberInput) {
        try {
            int bonusNumber = Integer.parseInt(bonusNumberInput.trim());
            if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
                throw new IllegalArgumentException(INVALID_BONUS_NUMBER_ERROR);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_ERROR);
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private boolean validateDuplicate(String bonusNumberInput, List<Integer> winningNumbers) {
        try {
            if (winningNumbers.contains(Integer.parseInt(bonusNumberInput))) {
                throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR);
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }
}
