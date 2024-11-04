package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.InputParser;
import lotto.validation.InputValidate;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoResultChecker;
import lotto.model.LottoStatistics;
import lotto.model.WinningRank;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class LottoController {
    private final InputHandler inputHandler;
    private final InputParser inputParser;
    private final OutputHandler outputHandler;
    private final LottoGenerator lottoGenerator;
    private final LottoResultChecker resultChecker;
    private final LottoStatistics statistics;

    public LottoController() {
        inputHandler = new InputHandler();
        inputParser = new InputParser(new InputValidate());
        outputHandler = new OutputHandler();
        lottoGenerator = new LottoGenerator();
        resultChecker = new LottoResultChecker();
        statistics = new LottoStatistics();
    }

    public void run() {
        int purchaseAmount = getValidPurchaseAmount();
        List<Lotto> lottos = lottoGenerator.generateLottos(purchaseAmount);
        outputHandler.printLottoNumbers(lottos.size(), lottos.stream().map(Lotto::getNumbers).toList());

        List<Integer> winningNumbers = getValidWinningNumbers();
        int bonusNumber = getValidBonusNumber(winningNumbers);

        Map<WinningRank, Integer> results = resultChecker.checkResults(lottos, winningNumbers, bonusNumber);
        outputHandler.printWinningStatistics(results);

        double yield = statistics.calculateYield(results, purchaseAmount);
        outputHandler.printYield(yield);
    }

    private int getValidPurchaseAmount() {
        while (true) {
            try {
                String input = inputHandler.getPurchaseAmount();
                return inputParser.parsePurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                String input = inputHandler.getWinningNumbers();
                return inputParser.parseWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String input = inputHandler.getBonusNumber();
                return inputParser.parseBonusNumber(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
