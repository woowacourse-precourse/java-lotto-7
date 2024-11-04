package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Client;
import lotto.model.LottoAnswer;
import lotto.model.WinningResult;
import lotto.util.InputParser;
import lotto.util.LottoMatcher;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Client client;
    private LottoAnswer lottoAnswer;

    public void run() {
        generateClient();
        client.buyLotto();
        printLottoTicket();
        generateLottoAnswer();
        printResult();
    }

    private void generateClient() {
        while (true) {
            try {
                OutputView.requestBudget();
                var budgetInput = InputView.getInput();
                var budget = InputParser.parseBudget(budgetInput);

                this.client = new Client(budget);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private void printLottoTicket() {
        var lottos = client.getLottos();
        OutputView.printPurchasedLotto(lottos);
    }

    private void generateLottoAnswer() {
        while (true) {
            try {
                var winningNumbers = getWinningNumbers();
                var bonusNumber = getBonusNumbers();

                this.lottoAnswer = new LottoAnswer(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumbers() {
        List<Integer> winningLotto = null;
        while (true) {
            try {
                OutputView.requestWinningLotto();
                var winningLottoInput = InputView.getInput();
                winningLotto = InputParser.parseWinningNumbers(winningLottoInput);

                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }

        return winningLotto;
    }

    private int getBonusNumbers() {
        int bonusNumber = 0;
        while (true) {
            try {
                OutputView.requestBonusNumber();
                var bonusNumberInput = InputView.getInput();
                bonusNumber = InputParser.parseBonusNumber(bonusNumberInput);

                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }

        return bonusNumber;
    }

    public void printResult() {
        Map<WinningResult, Integer> result = new HashMap<>();
        for (WinningResult winningResult : WinningResult.values()) {
            result.put(winningResult, 0);
        }

        var lottos = client.getLottos();
        lottos.forEach(lotto -> {
            var winningResult = LottoMatcher.match(lotto, lottoAnswer);
            result.put(winningResult, result.get(winningResult) + 1);
        });
        OutputView.printResultMessage(result);
    }
}
