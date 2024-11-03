package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningResult;
import lotto.global.exception.CustomException;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.console.ConsoleWriter;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Amount inputAmount = requestAmount();
        Lottos purchasedLottos = createLottos(inputAmount);
        Lotto winningNumbers = requestWinningNumbers();
        int bonusNumber = requestBonusNumber(winningNumbers);

        WinningResult result = new WinningResult(purchasedLottos, winningNumbers, bonusNumber);
        double profitRate = result.getProfitRate(inputAmount);
        outputView.printResult(result, profitRate);
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
