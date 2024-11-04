package lotto.presentation;

import lotto.application.LottoService;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.view.OutputProfitRateView;
import lotto.view.OutputRankView;

import java.util.Map;

public class LottoResultController {

  private final LottoService lottoService = new LottoService();

  public Map<Rank, Long> calculateRanks(LottoTicket lottoTicket, WinningLotto winningLotto) {
    return lottoService.calculateRanks(lottoTicket, winningLotto);
  }

  public void displayResults(Map<Rank, Long> rankResults, int purchaseAmount) {
    OutputRankView.printMatchResults(rankResults);
    int totalPrize = calculateTotalPrize(rankResults);
    double profitRate = calculateProfitRate(purchaseAmount, totalPrize);
    OutputProfitRateView.printProfitRate(profitRate);
  }

  private int calculateTotalPrize(Map<Rank, Long> rankResults) {
    return rankResults.entrySet().stream()
        .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue().intValue())
        .sum();
  }

  private double calculateProfitRate(int purchaseAmount, int totalPrize) {
    return lottoService.calculateProfitRate(purchaseAmount, totalPrize);
  }
}
