package lotto.validation;

import lotto.exception.InvalidPurchaseAmountException;

public final class PurchaseAmountValidation {
    public static int purchaseAmountValidation(String purchaseAmountStr) throws IllegalArgumentException {
        InputValidation.isNotBlank(purchaseAmountStr);
        int purchaseAmount = InputValidation.numberValidation(purchaseAmountStr);
        return validatePurchaseAmountAndGetLottoCount(purchaseAmount);
    }

    public static int validatePurchaseAmountAndGetLottoCount(int purchaseAmount) {
        if (purchaseAmount % 1000 == 0) {
            return purchaseAmount / 1000;
        }
        throw new InvalidPurchaseAmountException();
    }
}
