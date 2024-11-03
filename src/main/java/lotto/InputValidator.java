package lotto;


import static lotto.ErrorCode.*;

public class InputValidator {

    public void validatePurchaseAmount(int purchaseAmount) {
        validatePurchaseAmountFormat(purchaseAmount);
    }

    private void validatePurchaseAmountFormat(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
