package lotto.validation;

import lotto.exception.InvalidPurchaseAmountException;

public final class PurchaseAmountValidation {
    public static final int PRICE_UNIT = 1000;

    private PurchaseAmountValidation() {
    }

    public static int purchaseAmountValidationAndGetLottoQuantity(final String inputAmount)
            throws IllegalArgumentException {
        InputValidation.isNotBlank(inputAmount);
        int purchaseAmount = InputValidation.parseNumberValidation(inputAmount);
        validatePurchaseAmountBy1000(purchaseAmount);
        return convertToLottoQuantity(purchaseAmount);
    }

    private static void validatePurchaseAmountBy1000(final int purchaseAmount) {
        if (purchaseAmount % PRICE_UNIT != 0) {
            throw new InvalidPurchaseAmountException();
        }
    }

    private static int convertToLottoQuantity(final int purchaseAmount) {
        return purchaseAmount / PRICE_UNIT;
    }
}