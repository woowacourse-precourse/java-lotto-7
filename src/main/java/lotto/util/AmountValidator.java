package lotto.util;

import lotto.exception.InputErrorMessage;

public class AmountValidator {

    private AmountValidator() {
    }

    public static void validateAmount(int amount) {
        validatePositiveAmount(amount);
        validateDivisibility(amount);
        validateAmountLimit(amount);
    }

    private static void validatePositiveAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException(InputErrorMessage.NEGATIVE_OR_ZERO_AMOUNT.getMessage());
        }
    }

    private static void validateDivisibility(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateAmountLimit(int amount) {
        if (amount > 1000000) {
            throw new IllegalArgumentException(InputErrorMessage.EXCEEDS_LIMIT_AMOUNT.getMessage());
        }
    }
}
