package lotto.controller;

import lotto.view.LottoInputView;

public class LottoController {

    private final LottoInputView inputView;

    public LottoController(LottoInputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String priceInput = inputView.getPriceInput();
    }
}
