package lotto.validator;

import java.util.List;
import lotto.constant.Constant;
import lotto.error.ErrorMessage;

public class BonusValidator {

    public static void validate(List<Integer> winningNumbers, String bonusNumber) {
        if (!validateNotBlank(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK.getMessage());
        }
        if (!validateNumberFormat(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOWED_CHARS.getMessage());
        }
        if (!validateInRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NOT_IN_RANGE.getMessage());
        }
        if(!validateDuplication(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE.getMessage());
        }
    }

    private static boolean validateNotBlank(String bonusNumber) {
        return !bonusNumber.isBlank();
    }

    private static boolean validateNumberFormat(String bonusNumber) {
        try{
            Integer.parseInt(bonusNumber);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private static boolean validateInRange(String bonusNumber) {
        int bonus = Integer.parseInt(bonusNumber);
        return Constant.MIN_NUMBER <= bonus && bonus <= Constant.MAX_NUMBER;
    }

    private static boolean validateDuplication(List<Integer> winningNumbers, String bonusNumber) {
        int bonus = Integer.parseInt(bonusNumber);
        return !winningNumbers.contains(bonus);
    }
}
