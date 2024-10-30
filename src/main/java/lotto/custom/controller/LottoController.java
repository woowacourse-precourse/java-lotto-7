package lotto.custom.controller;

import lotto.custom.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController() {
        this.inputView = new InputView();
    }

    public void run() {
        String purchaseAmountInput = inputView.inputPurchaseAmount();
    }
}