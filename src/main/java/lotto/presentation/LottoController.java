package lotto.presentation;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.application.LottoService;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputLottoView;
import lotto.view.OutputProfitRateView;
import lotto.view.OutputRankView;

import java.util.List;
import java.util.Map;

public class LottoController {

  private final LottoService lottoService = new LottoService();

  public void run() {
    int purchaseAmount = getPurchaseAmount();
    LottoTicket lottoTicket = generateLottoTickets(purchaseAmount);

    WinningLotto winningLotto = getWinningLotto();
    Map<Rank, Long> rankResults = calculateRanks(lottoTicket, winningLotto);

    displayResults(rankResults, purchaseAmount);
  }

  private int getPurchaseAmount() {
    return InputView.getPurchaseAmount();
  }

  private LottoTicket generateLottoTickets(int purchaseAmount) {
    LottoTicket lottoTicket = lottoService.generateLottoTickets(purchaseAmount);
    OutputLottoView.printPurchasedTickets(lottoTicket.getTickets());
    return lottoTicket;
  }

  private WinningLotto getWinningLotto() {
    List<Integer> winningNumbers = parseWinningNumbers(InputView.getWinningNumbers());
    int bonusNumber = InputView.getBonusNumber();
    return lottoService.createWinningLotto(winningNumbers, bonusNumber);
  }

  private List<Integer> parseWinningNumbers(String input) {
    return Arrays.stream(input.split(","))
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  private Map<Rank, Long> calculateRanks(LottoTicket lottoTicket, WinningLotto winningLotto) {
    return lottoService.calculateRanks(lottoTicket, winningLotto);
  }

  private void displayResults(Map<Rank, Long> rankResults, int purchaseAmount) {
    OutputRankView.printMatchResults(rankResults);
    int totalPrize = calculateTotalPrize(rankResults);
    double profitRate = lottoService.calculateProfitRate(purchaseAmount, totalPrize);
    OutputProfitRateView.printProfitRate(profitRate);
  }

  private int calculateTotalPrize(Map<Rank, Long> rankResults) {
    return rankResults.entrySet().stream()
        .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue().intValue())
        .sum();
  }
}
