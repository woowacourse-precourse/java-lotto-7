package lotto.validation;

import lotto.constants.ErrorMessageConstants;

public class PurchaseAmountValidator {
    public static void validatePurchaseAmountInput(String purchaseAmountInput) {
        validateNotBlank(purchaseAmountInput);
        validateIsNumber(purchaseAmountInput);
    }

    public static void validatePurchaseAmount(int purchaseAmount) {
        validatePositiveAmount(purchaseAmount);
        validateLottoAmountUnit(purchaseAmount);
    }

    private static void validateNotBlank(String purchaseAmountInput) {
        if (purchaseAmountInput == null || purchaseAmountInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessageConstants.EMPTY_PURCHASE_AMOUNT);
        }
    }

    private static void validateIsNumber(String purchaseAmountInput) {
        try {
            Integer.parseInt(purchaseAmountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_NUMBER_FORMAT);
        }
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
}
