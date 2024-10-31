package lotto.controller;

import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;

    public LottoController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        outputView.printInputTotalCost();

    }
}
