package lotto.view;

import static lotto.constant.PrintText.REQUIRE_PURCHASE_AMOUNT;
import static lotto.constant.PrintText.REQUIRE_WINNING_NUMBERS;

public class PrintOutputView {
    public void printError(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }

    public void printRequirePurchaseAmount() {
        System.out.println(REQUIRE_PURCHASE_AMOUNT.getText());
    }

    public void printRequireWinningNumbers() {
        System.out.println(REQUIRE_WINNING_NUMBERS.getText());
    }
}
