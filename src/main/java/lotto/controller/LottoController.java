package lotto.controller;

public class LottoController {
    private Integer purchaseAmount = 0;
    private InputController inputController = new InputController();


    public void run() {
        initPurchaseAmount();
    }

    private void initPurchaseAmount() {
        this.purchaseAmount = inputController.initPurchaseAmount();
    }
}
