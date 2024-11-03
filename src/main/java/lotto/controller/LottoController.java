package lotto.controller;

import lotto.view.console.ConsoleWriter;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningCondition;
import lotto.domain.WinningResult;
import lotto.global.exception.CustomException;
import lotto.view.InputView;

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
        printResult(result, result.getProfitRate(inputAmount));
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

    private void printResult(WinningResult result, double profitRate) {
        ConsoleWriter.printlnMessage("당첨 통계");
        ConsoleWriter.printlnMessage("---");
        for (WinningCondition winningCondition : WinningCondition.getAllConditions().reversed()) {
            String format = determineFormat(winningCondition);
            String str = String.format(
                    format,
                    winningCondition.getWinningNumberCount(),
                    String.format("%,d", winningCondition.getRewardAmount()),
                    result.getResultMap().get(winningCondition).size()
            );
            ConsoleWriter.printlnMessage(str);
        }
        String str = String.format("총 수익률은 %s%%입니다.", profitRate);
        ConsoleWriter.printlnMessage(str);
    }

    private String determineFormat(WinningCondition winningCondition) {
        if (winningCondition.mustIncludeBonusNumber()) {
            return "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
        }
        return "%d개 일치 (%s원) - %d개";
    }
}
