package lotto.Controller;

import java.util.List;
import lotto.Domain.LottoGame;
import lotto.Domain.LottoMachine;
import lotto.Domain.Lottos;
import lotto.Domain.PurchaseAmount;
import lotto.Domain.WinningAnalyzer;
import lotto.Domain.WinningNumbers;
import lotto.Domain.WinningResult;
import lotto.Messages.ErrorMessage;
import lotto.Messages.OutputMessage;
import lotto.Utils.Formatter;
import lotto.Utils.UserInput;
import lotto.View.OutputView;

public class LottoGameController {
    private final UserInput userInput;
    private LottoGame game;

    public LottoGameController() {
        userInput = new UserInput();
    }

    public void run() {
        ready();
        draw();
        result();
    }

    private void ready() {
        game = LottoGame.create();
        Lottos issuedLottos;
        while (true) {
            try {
                String amountInput = userInput.purchaseAmount();
                PurchaseAmount amount = PurchaseAmount.from(amountInput);
                LottoMachine machine = LottoMachine.create();
                issuedLottos = machine.buyLottos(amount);
                game.setAmount(amount.getValue());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(ErrorMessage.ERROR_PREFIX.getMessage() + e.getMessage());
            }
        }
        game.setIssuedLottos(issuedLottos);

        OutputView.printMessage();

        String result = Formatter.formatLottoCount(issuedLottos);
        OutputView.printMessage(result);

        List<String> lottoResult = Formatter.formatLottos(issuedLottos);
        OutputView.printMessages(lottoResult);
    }

    private void draw() {
        OutputView.printMessage();
        WinningNumbers winningNumbers = WinningNumbers.create();
        while (true) {
            try {
                String winningNumbersInput = userInput.winningNumbers();
                winningNumbers.registerMainNumbers(winningNumbersInput);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(ErrorMessage.ERROR_PREFIX.getMessage() + e.getMessage());
            }
        }

        OutputView.printMessage();
        while (true) {
            try {
                String bonusNumberInput = userInput.bonusNumber();
                winningNumbers.registerBonus(bonusNumberInput);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(ErrorMessage.ERROR_PREFIX.getMessage() + e.getMessage());
            }
        }

        game.setWinningNumbers(winningNumbers);
    }

    private void result() {
        OutputView.printMessage();
        WinningAnalyzer winningAnalyzer = new WinningAnalyzer();
        WinningResult winningResult = winningAnalyzer.analyze(game.getIssuedLottos(), game.getWinningNumbers());
        game.setWinningResult(winningResult);

        List<String> winningStatistics = Formatter.formatWinningStatistics(winningResult);
        OutputView.printMessages(winningStatistics);

        double profit = game.calculateProfit();
        String totalYieldMessage = String.format(OutputMessage.TOTAL_PROFIT.getMessage(), profit);
        OutputView.printMessage(totalYieldMessage);
    }

}