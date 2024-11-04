package lotto.service.handler;

import lotto.service.validator.PurchaseAmountValidator;

public class PurchaseAmountHandler {
    public static boolean handle(String purchaseAmount) {
        return PurchaseAmountValidator.validateBlank(purchaseAmount) && PurchaseAmountValidator.validateDivisibleBy1000(purchaseAmount);
    }

}
