package lotto.controller;

import java.util.List;
import java.util.Map;

import lotto.service.LottoGenerationService;
import lotto.service.LottoResultService;
import lotto.service.LottoStatisticsService;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
    private final LottoGenerationService generationService;
    private final LottoResultService resultService;
    private final LottoStatisticsService statisticsService;

    public LottoGame() {
        this.generationService = new LottoGenerationService();
        this.resultService = new LottoResultService();
        this.statisticsService = new LottoStatisticsService();
    }

    public void start() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        List<Lotto> lottos = generationService.generateLottos(purchaseAmount);
        ResultView.printLottos(lottos);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        Map<Rank, Integer> results = resultService.calculateResults(lottos, winningNumbers, bonusNumber);
        int totalPrize = statisticsService.calculateTotalPrize(results);
        double profitRate = statisticsService.calculateProfitRate(totalPrize, purchaseAmount);

        ResultView.printResults(results, profitRate);
    }
}
