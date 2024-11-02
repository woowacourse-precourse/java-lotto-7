package lotto.validation;

import lotto.enumValue.ExceptionMessage;

public class MoneyValidation {
    public static void isPositiveNumber(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NEGATIVE_NUMBER.getErrorDescription());
        }
    }

    public static void divide1000(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_DIVIDE_1000.getErrorDescription());
        }
    }
}
