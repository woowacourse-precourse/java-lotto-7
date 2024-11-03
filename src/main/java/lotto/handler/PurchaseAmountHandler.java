package lotto.handler;

import lotto.validator.PurchaseAmountValidator;

public class PurchaseAmountHandler {
    public static void handle(String purchaseAmount) {
        PurchaseAmountValidator.validateBlank(purchaseAmount);
        PurchaseAmountValidator.validateDivisibleBy1000(purchaseAmount);
    }
}
