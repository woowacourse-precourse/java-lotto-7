package lotto.validation;

import lotto.constants.ErrorMessageConstants;

public class PurchaseAmountValidator {
    private PurchaseAmountValidator() {
        throw new IllegalStateException(ErrorMessageConstants.INSTANCE_CREATION_ERROR);
    }

    public static void validatePurchaseAmountInput(String purchaseAmountInput) {
        ValidationUtils.validateNotBlank(purchaseAmountInput, ErrorMessageConstants.EMPTY_PURCHASE_AMOUNT);
        ValidationUtils.validateIsNumber(purchaseAmountInput, ErrorMessageConstants.INVALID_NUMBER_FORMAT);
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
}
