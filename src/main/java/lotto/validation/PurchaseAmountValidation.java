package lotto.validation;

import lotto.exception.InvalidPurchaseAmountException;

public final class PurchaseAmountValidation {
    public static int purchaseAmountValidationAndGetLottoQuantity(String purchaseAmountStr)
            throws IllegalArgumentException {
        InputValidation.isNotBlank(purchaseAmountStr);
        int purchaseAmount = InputValidation.parseNumberValidation(purchaseAmountStr);
        validatePurchaseAmountBy1000(purchaseAmount);
        return convertToLottoQuantity(purchaseAmount);
    }

    private static void validatePurchaseAmountBy1000(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new InvalidPurchaseAmountException();
        }
    }

    private static int convertToLottoQuantity(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}