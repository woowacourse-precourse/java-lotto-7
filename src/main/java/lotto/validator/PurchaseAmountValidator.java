package lotto.validator;

import lotto.common.ErrorMessage;

public class PurchaseAmountValidator {

    public int validatePurchaseAmount(String purchaseAmountInput) {

        if (purchaseAmountInput == null || purchaseAmountInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY.getMessage());
        }

        try {
            int purchaseAmount = Integer.parseInt(purchaseAmountInput);
            if (purchaseAmount <= 0) {
                throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE.getMessage());
            }
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessage.NOT_DISABLE_BY_1000.getMessage());
            }
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }
}
