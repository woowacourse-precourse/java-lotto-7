package lotto;

import lotto.controller.PurchaseController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PurchaseController purchaseController = new PurchaseController();
        purchaseController.purchaseLottos();
    }
}
