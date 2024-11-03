package lotto.presentation.controller;

import lotto.presentation.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        String amountInput = inputView.inputPurchaseAmount();
    }
}
