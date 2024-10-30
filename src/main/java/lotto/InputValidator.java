package lotto;

import static lotto.ErrorCode.INVALID_PURCHASE_AMOUNT;

public class InputValidator {

    private static final int TICKET_PRICE = 1000;

    public static void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

}
