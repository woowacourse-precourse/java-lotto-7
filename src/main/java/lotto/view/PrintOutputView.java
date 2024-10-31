package lotto.view;

import static lotto.constant.PrintText.REQUIRE_PURCHASE_AMOUNT;

public class PrintOutputView {
    public void printError(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }

    public void printRequirePurchaseAmount() {
        System.out.println(REQUIRE_PURCHASE_AMOUNT.getText());
    }
}
