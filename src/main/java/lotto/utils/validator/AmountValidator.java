package lotto.utils.validator;

import static lotto.constants.ErrorMessage.*;

public class AmountValidator {

    public static void validateLottoAmount(String amounts) {
        checkEmptyAmounts(amounts);
        checkNonNumericAmounts(amounts);
    }

    private static void checkEmptyAmounts(String amounts) {
        if (amounts.isBlank()) {
            throw new IllegalArgumentException(EMPTY_AMOUNT.getMessage());
        }
    }

    private static void checkNonNumericAmounts(String amounts) {
        for (int i = 0; i < amounts.length(); i++) {
            if (!Character.isDigit(amounts.charAt(i))) {
                throw new IllegalArgumentException(ONLY_DIGITS_ALLOWED_AMOUNTS.getMessage());
            }
        }
    }
}
