package lotto.utils.validator;

import static lotto.constants.ErrorMessage.EMPTY_LOTTO_BONUS_NUMBERS;
import static lotto.constants.ErrorMessage.ONLY_DIGITS_ALLOWED;

public class BonusNumberValidator {

    public static void validateNumber(String userBonusNumber) {
        checkEmptyNumber(userBonusNumber);
        checkNonNumeric(userBonusNumber);
    }

    private static void checkEmptyNumber(String userBonusNumber) {
        if (userBonusNumber.isBlank()) {
            throw new IllegalArgumentException(EMPTY_LOTTO_BONUS_NUMBERS.getMessage());
        }
    }

    private static void checkNonNumeric(String userBonusNumber) {
        for (int i = 0; i < userBonusNumber.length(); i++) {
            if (!Character.isDigit(userBonusNumber.charAt(i))) {
                throw new IllegalArgumentException(ONLY_DIGITS_ALLOWED.getMessage());
            }
        }
    }
}
