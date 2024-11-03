package lotto.controller;

import lotto.domain.Money;

public class GameController {

    private final PurchaseController purchaseController;
    private final WinController winController;

    public GameController(PurchaseController purchaseController, WinController winController) {
        this.purchaseController = purchaseController;
        this.winController = winController;
    }

    public void run(){
        Money money = purchaseController.purchaseLottos();
        winController.win(money);
    }
}
