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
        Lottos lottos = createLottos(amount);
    }

    private Amount requestAmount() {
        try {
            Amount amount = new Amount(inputView.enterAmount());
            ConsoleWriter.printEmptyLine();
            return amount;
        } catch (CustomException e) {
            ConsoleWriter.printlnMessageWithEmptyLine(e.getMessage());
            return requestAmount();
        }
    }

    private Lottos createLottos(Amount amount) {
        Lottos lottos = new Lottos(amount);
        ConsoleWriter.printlnMessageWithEmptyLine(lottos.toString());
        return lottos;
    }
}
