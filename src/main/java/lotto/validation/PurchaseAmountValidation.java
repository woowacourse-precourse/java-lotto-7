package lotto.validation;

import lotto.exception.InvalidPurchaseAmountException;

public final class PurchaseAmountValidation {
    public static int purchaseAmountValidationAndGetLottoQuantity(final String purchaseAmountStr)
            throws IllegalArgumentException {
        InputValidation.isNotBlank(purchaseAmountStr);
        int purchaseAmount = InputValidation.parseNumberValidation(purchaseAmountStr);
        validatePurchaseAmountBy1000(purchaseAmount);
        return convertToLottoQuantity(purchaseAmount);
    }

    private static void validatePurchaseAmountBy1000(final int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new InvalidPurchaseAmountException();
        }
    }

    private static int convertToLottoQuantity(final int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}