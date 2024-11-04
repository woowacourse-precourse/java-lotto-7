package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningResult;
import lotto.service.LottoEvaluator;
import lotto.service.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;
    private final LottoEvaluator lottoEvaluator;

    public LottoGameController(InputView inputView, OutputView outputView, LottoGenerator lottoGenerator,
                               LottoEvaluator lottoEvaluator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
        this.lottoEvaluator = lottoEvaluator;
    }

    public void run() {
        inputView.displayLottoPurchaseAmountPrompt();
        int lottoPurchaseAmount = parseNumber(inputView.readLottoPurchaseAmount());
        Lottos lottos = Lottos.from(lottoGenerator.issue(lottoPurchaseAmount));
        outputView.displayLottoCount(lottos);
        outputView.displayLottoNumbers(lottos);

        inputView.displayWinningNumbersPrompt();
        List<Integer> parsedWinningNumbers = parseWinningNumbers(inputView.readWinningNumbers());
        WinningNumbers winningNumbers = WinningNumbers.from(parsedWinningNumbers);

        inputView.displayBonusNumberPrompt();
        int parsedBonusNumber = parseNumber(inputView.readBonusNumber());
        BonusNumber bonusNumber = new BonusNumber(parsedBonusNumber);

        Map<WinningResult, Integer> winningResults = lottoEvaluator.evaluateWinningResult(lottos, winningNumbers,
                bonusNumber);
        outputView.displayWinningResult(winningResults);

        double profitRate = lottoEvaluator.evaluateProfitRate(winningResults, lottoPurchaseAmount);
    }

    private List<Integer> parseWinningNumbers(String userInput) {
        List<Integer> numbers = new ArrayList<>();
        String[] userInputNumbers = userInput.split(",", -1);

        for (String userInputNumber : userInputNumbers) {
            int number = parseNumber(userInputNumber.trim());
            numbers.add(number);
        }

        return numbers;
    }

    private int parseNumber(String userInputNumber) {
        return Integer.parseInt(userInputNumber);
    }
}
