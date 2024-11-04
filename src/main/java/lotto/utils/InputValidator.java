package lotto.utils;

import static lotto.constans.ErrorMessages.ERROR_EMPTY_AMOUNT;
import static lotto.constans.ErrorMessages.ERROR_NON_NUMERIC_AMOUNT;

public class InputValidator {

    public static void validateNonEmptyAmount(String money) {
        if (money.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_AMOUNT);
        }
    }

    public static void validateNumericAmount(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_AMOUNT);
        }
    }
}
