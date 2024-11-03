package lotto.view.controller;

import lotto.view.InputView;
import lotto.view.console.ConsoleWriter;
import lotto.view.domain.Amount;
import lotto.view.domain.Lotto;
import lotto.view.domain.Lottos;
import lotto.view.domain.WinningResult;
import lotto.view.global.exception.CustomException;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Amount inputAmount = requestAmount();
        Lottos purchasedLottos = createLottos(inputAmount);
        Lotto winningNumbers = requestWinningNumbers();
        int bonusNumber = requestBonusNumber(winningNumbers);

        WinningResult result = new WinningResult(purchasedLottos, winningNumbers, bonusNumber);
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

    private Lotto requestWinningNumbers() {
        try {
            Lotto lotto = new Lotto(inputView.enterWinningNumbers());
            ConsoleWriter.printEmptyLine();
            return lotto;
        } catch (CustomException e) {
            ConsoleWriter.printlnMessageWithEmptyLine(e.getMessage());
            return requestWinningNumbers();
        }
    }

    private int requestBonusNumber(Lotto winningNumbers) {
        try {
            int number = inputView.enterBonusNumber();
            winningNumbers.validateNumber(number);
            ConsoleWriter.printEmptyLine();
            return number;
        } catch (CustomException e) {
            ConsoleWriter.printlnMessageWithEmptyLine(e.getMessage());
            return requestBonusNumber(winningNumbers);
        }
    }
}
