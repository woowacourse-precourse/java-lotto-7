package lotto.view;

import static lotto.ExceptionMessage.PURCHASE_AMOUNT_NOT_NUMERIC_EXCEPTION;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseAmountInputView {
    private static final String PURCHASE_AMOUNT_INPUT_GUIDE = "구입금액을 입력해 주세요.";

    public void printPurchaseAmountInputGuide() {
        System.out.println(PURCHASE_AMOUNT_INPUT_GUIDE);
    }

    public long getPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        validatePurchaseAmountIsNumeric(purchaseAmount);
        return Long.parseLong(purchaseAmount);
    }

    private void validatePurchaseAmountIsNumeric(String purchaseAmount) {
        if (!purchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_NUMERIC_EXCEPTION.message());
        }
    }
}
