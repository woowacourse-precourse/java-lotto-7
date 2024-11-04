package lotto.validator;

import java.util.Set;
import lotto.message.ErrorMessage;

public class BonusNumberValidator {
    public static int validateBonusNumber(String bonusNumber, Set<Integer> winningNumber) {
        checkNullOrEmptyNumber(bonusNumber);
        checkInteger(bonusNumber);
        checkValidBonusNumber(bonusNumber);
        checkDuplicateBonusNumber(bonusNumber, winningNumber);
        return Integer.parseInt(bonusNumber);
    }

    private static void checkNullOrEmptyNumber(String bonusNumber) {
        if (bonusNumber == null || bonusNumber.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL_OR_EMPTY.getMessage());
        }
    }

    private static void checkInteger(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    private static void checkValidBonusNumber(String bonusNumber) {
        int bonusNumberInt = Integer.parseInt(bonusNumber);
        if (bonusNumberInt > 45 || bonusNumberInt < 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    private static void checkDuplicateBonusNumber(String bonusNumber, Set<Integer> winningNumber) {
        if (winningNumber.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
