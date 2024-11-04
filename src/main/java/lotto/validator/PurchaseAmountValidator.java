package lotto.validator;

import static lotto.constant.ErrorCode.INVALID_PURCHASE_AMOUNT;

import lotto.view.OutputView;

public class PurchaseAmountValidator {

    private static final int TICKET_PRICE = 1000;

    public static void validate(int purchaseAmount) {
        if (purchaseAmount == 0 || purchaseAmount % TICKET_PRICE != 0) {
            OutputView.printError(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

}
