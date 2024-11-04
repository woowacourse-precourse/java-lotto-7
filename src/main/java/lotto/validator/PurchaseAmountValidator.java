package lotto.validator;

public class PurchaseAmountValidator {
    public static int validatePurchaseAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }
}
