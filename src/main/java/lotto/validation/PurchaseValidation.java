package lotto.validation;

import lotto.exception.InvalidPurchaseAmountException;

public final class PurchaseValidation {
    public static int purchaseAmountValidation(String inputValue) throws IllegalArgumentException {
        InputValidation.isNotBlank(inputValue);
        int amount = InputValidation.parseValidateNumber(inputValue);
        invalidPurchaseAmountValidation(amount);
        return amount;
    }

    public static void invalidPurchaseAmountValidation(int amount) {
        if (amount % 1000 != 0) {
            throw new InvalidPurchaseAmountException();
        }
    }
}
