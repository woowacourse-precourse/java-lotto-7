package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.common.Winning;
import lotto.domain.Lotto;
import lotto.service.LottoResultService;
import lotto.view.OutputView;

public class LottoResultController {
    private final LottoResultService lottoResultService;

    private final OutputView outputView;

    public LottoResultController() {
        this.lottoResultService = new LottoResultService();
        this.outputView = new OutputView();
    }

    public Map<Winning, Integer> getWinnings(List<Lotto> lottos, List<Integer> winningNumbers, int bonus) {
        return lottoResultService.getWinnings(lottos, winningNumbers, bonus);
    }

    public double getYield(Map<Winning, Integer> winnings, int payment) {
        int totalWinnings = lottoResultService.calculateTotalWinnings(winnings);
        return lottoResultService.calculateYield(payment, totalWinnings);
    }

    public void printResult(Map<Winning, Integer> winnings, double yield) {
        outputView.printResult(winnings, yield);
    }
}
