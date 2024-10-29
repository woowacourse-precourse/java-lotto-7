package lotto;

import lotto.controller.PurchaseAmountController;

public class Application {

    private static final PurchaseAmountController purchaseAmountController = new PurchaseAmountController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        purchaseAmountController.getPurchaseAmount();
    }
}
