package lotto;


import static lotto.ErrorCode.*;

public class InputValidator {

    public void validatePurchaseAmount(String purchaseAmount) {
        validateIsNumber(purchaseAmount);
        validateProperFormat(purchaseAmount);
    }

    private void validateIsNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private void validateProperFormat(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
