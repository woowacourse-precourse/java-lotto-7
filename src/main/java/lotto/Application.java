package lotto;

import lotto.controller.BonusNumberController;
import lotto.controller.PurchaseAmountController;
import lotto.controller.WinningNumbersController;

public class Application {

    private static final PurchaseAmountController purchaseAmountController = new PurchaseAmountController();
    private static final WinningNumbersController winningNumbersController = new WinningNumbersController();
    private static final BonusNumberController bonusNumberController = new BonusNumberController();

    public static void main(String[] args) {
        purchaseAmountController.getPurchaseAmount();
        winningNumbersController.getWinningNumbers();
        bonusNumberController.getBonusNumber();
    }
}
