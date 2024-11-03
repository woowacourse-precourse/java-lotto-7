package lotto;

import java.util.List;
import java.util.regex.Pattern;

public class InputBonusValidator {
    private static final String BONUS_NUMBER_REGEX_PATTERN = "\\d+";
    private static final int BONUS_NUMBER_MAX = 45;
    private static final int BONUS_NUMBER_MINIMUM = 1;

    private final String bonusNumber;

    public InputBonusValidator(String bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber() {
        if (!Pattern.matches(BONUS_NUMBER_REGEX_PATTERN, bonusNumber)) {
            ErrorMessageUtil.BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE.errorException();
        }
    }

    private void checkSameNumberInWinningNumber(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            ErrorMessageUtil.BONUS_NUMBER_REPEAT_ERROR_MESSAGE.errorException();
        }
    }

    private void validateNumberRange() {
        if (Integer.parseInt(bonusNumber) > BONUS_NUMBER_MAX || Integer.parseInt(bonusNumber) < BONUS_NUMBER_MINIMUM) {
            ErrorMessageUtil.BONUS_NUMBER_RANGE_ERROR_MESSAGE.errorException();
        }
    }

    public int getBonusNumber(List<Integer> winningNumber) {
        validateBonusNumber();
        checkSameNumberInWinningNumber(winningNumber,Integer.parseInt(bonusNumber));
        validateNumberRange();
        return Integer.parseInt(bonusNumber);
    }
}
