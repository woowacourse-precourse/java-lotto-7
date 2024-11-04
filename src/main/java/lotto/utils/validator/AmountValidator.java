package lotto.utils.validator;

import static lotto.constants.ErrorMessage.*;

public class AmountValidator {

    public static void validateLottoAmount(String amount) {
        checkEmptyAmount(amount);
        checkNonNumericAmount(amount);
    }

    private static void checkEmptyAmount(String amount) {
        if (amount.isBlank()) {
            throw new IllegalArgumentException(EMPTY_AMOUNT.getMessage());
        }
    }

    private static void checkNonNumericAmount(String amount) {
        for (int i = 0; i < amount.length(); i++) {
            if (!Character.isDigit(amount.charAt(i))) {
                throw new IllegalArgumentException(ONLY_DIGITS_ALLOWED_AMOUNT.getMessage());
            }
        }
    }
}
