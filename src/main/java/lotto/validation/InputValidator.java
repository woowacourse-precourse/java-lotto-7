package lotto.validation;

import lotto.constants.ErrorMessageConstants;

public class InputValidator {
    public static void validatePurchaseAmountInput(String purchaseAmount) {
        validateNotBlank(purchaseAmount);
    }

    public static void validatePurchaseAmount(int purchaseAmount) {
        validatePositiveAmount(purchaseAmount);
        validateLottoAmountUnit(purchaseAmount);
    }

    private static void validatePositiveAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_NON_POSITIVE_PURCHASE_AMOUNT);
        }
    }

    private static void validateLottoAmountUnit(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_LOTTO_AMOUNT_UNIT);
        }
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessageConstants.EMPTY_PURCHASE_AMOUNT);
        }
    }
}
