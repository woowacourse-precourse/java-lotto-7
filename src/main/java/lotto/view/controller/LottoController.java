package lotto.view.controller;

import lotto.view.InputView;
import lotto.view.console.ConsoleWriter;
import lotto.view.domain.Amount;
import lotto.view.domain.Lottos;
import lotto.view.global.exception.CustomException;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Amount amount = requestAmount();
        Lottos lottos = new Lottos(amount);
    }

    private Amount requestAmount() {
        try {
            return new Amount(inputView.enterAmount());
        } catch (CustomException e) {
            ConsoleWriter.printlnMessage(e.getMessage());
            return requestAmount();
        }
    }
}
