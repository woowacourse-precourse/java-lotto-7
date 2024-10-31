package lotto.validation;

import lotto.exception.InvalidPurchaseAmountException;

public final class PurchaseAmountValidation {
    public static int purchaseAmountValidation(String purchaseAmountStr) throws IllegalArgumentException {
        InputValidation.isNotBlank(purchaseAmountStr);
        int purchaseAmount = InputValidation.numberValidation(purchaseAmountStr);
        invalidPurchaseAmountValidation(purchaseAmount);
        return purchaseAmount;
    }

    public static void invalidPurchaseAmountValidation(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new InvalidPurchaseAmountException();
        }
    }
}
