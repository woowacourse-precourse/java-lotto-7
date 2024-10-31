package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;

    public LottoController() {
        this.inputView = new InputView();
    }

    public void run() {
        inputView.printPurchaseAmountInput();
        inputView.getInput();
    }
}
