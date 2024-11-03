package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.RankResult;
import lotto.domain.RankType;
import lotto.model.InputParser;
import lotto.model.LottoGenerator;
import lotto.model.StatisticsCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final InputParser inputParser;
    private final LottoGenerator lottoGenerator;
    private final StatisticsCalculator statisticsCalculator;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.inputParser = new InputParser();
        this.lottoGenerator = new LottoGenerator();
        this.statisticsCalculator = new StatisticsCalculator();
        this.outputView = new OutputView();
    }

    public void executeLottoWorkflow() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoList = lottoGenerator.generateLottoList(purchaseAmount);
        outputView.displayLottoList(purchaseAmount, lottoList);

        Lotto winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        Map<RankType, RankResult> statistics =
            statisticsCalculator.calculateStatistics(lottoList, winningNumbers, bonusNumber);
        String earningRate = statisticsCalculator.calculateEarningRate(purchaseAmount);
        outputView.displayStatistics(statistics, earningRate);
    }

    public int getPurchaseAmount() {
        while (true) {
            try {
                String input = inputView.readPurchaseAmount();
                int purchaseAmount = inputParser.parsePurchaseAmount(input);
                System.out.println();
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto getWinningNumbers() {
        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                Lotto winningNumbers = inputParser.parseWinningNumbers(input);
                System.out.println();
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                String input = inputView.readBonusNumber();
                int bonusNumber = inputParser.parseBonusNumber(winningNumbers, input);
                System.out.println();
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}