package lotto.view.controller;

import lotto.view.InputView;
import lotto.view.domain.Amount;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Amount inputAmount = new Amount(inputView.enterAmount());
    }
}
