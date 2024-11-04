package lotto.domain;

import lotto.exception.PurchaseAmountErrorMessage;

public class PurchaseAmount {

    private final int purchaseAmount;

    public PurchaseAmount(String userInput) {
        int purchaseAmount = validateRange(userInput);
        validateDivisible(purchaseAmount);

        this.purchaseAmount = purchaseAmount;
    }

    public int getCanBuyLottoCount() {
        return purchaseAmount / 1000;
    }

    private int validateRange(String purchaseAmount) {
        try {
            int result = Integer.parseInt(purchaseAmount);

            if (result < 1) {
                throw new NumberFormatException();
            }
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PurchaseAmountErrorMessage.IS_NOT_POSSIBLE_RANGE.getMessage());
        }
    }

    private void validateDivisible(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(PurchaseAmountErrorMessage.IS_NOT_DIVISIBLE.getMessage());
        }
    }
}
