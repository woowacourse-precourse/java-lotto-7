package lotto.util;



import static lotto.exception.printException.throwIllegalArgException;

import lotto.domain.Lotto;
import lotto.exception.ErrorMessage;

public class InputValidator {

    private static final String LOTTO_NUMBER_RANGE_REGEX = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";

    public static void validateNullAndEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throwIllegalArgException(ErrorMessage.EMPTY_INPUT_VALUE);
        }
    }
    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throwIllegalArgException(ErrorMessage.INVALID_NUM);
        }
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throwIllegalArgException(ErrorMessage.INVALID_PURCHASE_AMOUNT);
        }
    }

    public static void validateRange(int bonusNumber) {
        Integer parsedNumber = bonusNumber;
        if (!parsedNumber.toString().matches(LOTTO_NUMBER_RANGE_REGEX)) {
            throwIllegalArgException(ErrorMessage.LOTTO_NUM_NOT_IN_RANGE);
        }
    }

    public static void validateDuplicate(Lotto winningLotto, int bonusNumber) {
        boolean hasDuplicate = winningLotto.getNumbers().stream()
                .anyMatch(number -> number == bonusNumber);

        if (hasDuplicate) {
            throwIllegalArgException(ErrorMessage.BONUS_NUM_DUPLICATE);
        }
    }
}
