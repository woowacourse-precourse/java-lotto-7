package lotto.controller;

import lotto.model.PurchaseLotto;

public class LottoController {

    private final InputController inputController;

    public LottoController(final InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        PurchaseLotto purchaseLotto = inputController.moneyToLottoList();

    }
}
