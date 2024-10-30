package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseAmountInputView {
    private static final String PURCHASE_AMOUNT_INPUT_GUIDE = "구입금액을 입력해 주세요.";

    public void printPurchaseAmountInputGuide() {
        System.out.println(PURCHASE_AMOUNT_INPUT_GUIDE);
    }

    public String getPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        return purchaseAmount;
    }
}
