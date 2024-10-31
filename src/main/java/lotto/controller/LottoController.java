package lotto.controller;

import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;

    public LottoController(final OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        outputView.printPurchasePriceRequest();
    }
}
