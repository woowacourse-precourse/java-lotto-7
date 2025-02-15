package lotto.validator;

import static lotto.constant.ErrorCode.INVALID_PURCHASE_AMOUNT;

public class PurchaseAmountValidator {

    private static final int TICKET_PRICE = 1000;

    public static void validate(int purchaseAmount) {
        if (purchaseAmount == 0 || purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

}
