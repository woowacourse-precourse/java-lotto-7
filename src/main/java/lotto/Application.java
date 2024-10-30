package lotto;

import lotto.controller.PurchaseAmountController;
import lotto.controller.WinningNumbersController;

public class Application {

    private static final PurchaseAmountController purchaseAmountController = new PurchaseAmountController();
    private static final WinningNumbersController winningNumbersController = new WinningNumbersController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        purchaseAmountController.getPurchaseAmount();
        winningNumbersController.getWinningNumbers();
    }
}
