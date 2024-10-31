package lotto.parse;

import lotto.constant.ExceptionMessage;

public class InputParser {

    public Long parsePurchaseAmount(String purchaseAmount) {
        try {
            return Long.parseLong(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_MUST_LONG, e);
        }
    }
}
