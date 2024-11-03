package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningResult;
import lotto.global.message.InputMessage;
import lotto.global.exception.CustomException;
import lotto.view.InputView;
import lotto.view.OutputView;

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
        outputView.printlnMessage(InputMessage.INPUT_AMOUNT.getMessage());
        try {
            Amount amount = new Amount(inputView.enterAmount());
            outputView.printEmptyLine();
            return amount;
        } catch (CustomException e) {
            outputView.printlnMessageWithEmptyLine(e.getMessage());
            return requestAmount();
        }
    }

    private Lottos createLottos(Amount amount) {
        Lottos lottos = new Lottos(amount);
        outputView.printlnCreateLottos(lottos);
        return lottos;
    }

    private Lotto requestWinningNumbers() {
        outputView.printlnMessage(InputMessage.INPUT_WINNING_NUMBERS.getMessage());
        try {
            Lotto lotto = new Lotto(inputView.enterWinningNumbers());
            outputView.printEmptyLine();
            return lotto;
        } catch (CustomException e) {
            outputView.printlnMessageWithEmptyLine(e.getMessage());
            return requestWinningNumbers();
        }
    }

    private int requestBonusNumber(Lotto winningNumbers) {
        outputView.printlnMessage(InputMessage.INPUT_BONUS_NUMBER.getMessage());
        try {
            int number = inputView.enterBonusNumber();
            winningNumbers.validateNumber(number);
            outputView.printEmptyLine();
            return number;
        } catch (CustomException e) {
            outputView.printlnMessageWithEmptyLine(e.getMessage());
            return requestBonusNumber(winningNumbers);
        }
    }
}
