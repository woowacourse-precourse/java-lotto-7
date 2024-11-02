package lotto;

import lotto.controller.PurchaseController;

public class Application {
    public static void main(String[] args) {
        final PurchaseController purchaseController = new PurchaseController();
        purchaseController.processLottoGame();
    }
}
