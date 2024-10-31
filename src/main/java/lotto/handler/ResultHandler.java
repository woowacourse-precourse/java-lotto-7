package lotto.handler;

import java.util.List;
import java.util.Map;
import lotto.model.PrizeTier;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class ResultHandler {
    private final LottoService lottoService;
    private final OutputView outputView;
    private List<PrizeTier> prizeResults;

    public ResultHandler(LottoService lottoService, OutputView outputView) {
        this.lottoService = lottoService;
        this.outputView = outputView;
        this.prizeResults = List.of();
    }

    public void calculateResults() {
        this.prizeResults = lottoService.calculateResults();
    }

    public void printWinningResults() {
        Map<PrizeTier, Integer> prizeCounts = lottoService.getWinningCounts(prizeResults);
        outputView.printWinningResults(prizeCounts);
    }

    public void printProfitRate(int purchaseAmount) {
        double profitRate = lottoService.calculateProfitRate(prizeResults, purchaseAmount);
        outputView.printProfitRate(profitRate);
    }

}
