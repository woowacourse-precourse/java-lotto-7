package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(OutputView outputView, InputView inputVIew) {
        this.outputView = outputView;
        this.inputView = inputVIew;
    }

    public void run() {
        outputView.askPurchasePrice();
        String input = inputView.inputPurchasePrice();
    }
}
