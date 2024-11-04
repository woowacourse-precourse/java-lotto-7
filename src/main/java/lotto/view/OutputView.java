package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoTickets;
import lotto.util.LottoConstants;
import lotto.util.Ranking;

public class OutputView {
    private static final String purchaseMessage = "개를 구매했습니다.";
    private static final String RESULT_TITLE = "당첨 통계";
    private static final String LINE = "---";
    private static final String STATISTICS_MESSAGE = "%d개 일치, (%,d원) - %d개\n";
    private static final String BONUS_STATISTICS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%입니다.\n";

    private final LottoTickets lottoTickets;

    public OutputView(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void showLottoTickets(int purchaseAmount) {
        int ticketCount = purchaseAmount / LottoConstants.LOTTO_PRICE;

        System.out.println();
        System.out.println(ticketCount + purchaseMessage);
        System.out.println(lottoTickets.getLottoTicket());
    }

    public void showResult(List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        System.out.println();
        System.out.println(RESULT_TITLE);
        System.out.println(LINE);

        Map<Ranking, Integer> winningStatistics = lottoTickets.calculateWinningStatistics(winningNumbers, bonusNumber);
        printWinningStatistics(winningStatistics);
        printProfitRate(winningStatistics, purchaseAmount);
    }

    private void printProfitRate(Map<Ranking, Integer> winningStatistics, int purchaseAmount) {
        double profitRate = lottoTickets.calculateProfitRate(winningStatistics, purchaseAmount);
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }

    private void printWinningStatistics(Map<Ranking, Integer> winningStatistics) {
        for (Ranking ranking : Ranking.values()) {
            int count = winningStatistics.get(ranking);

            if (ranking == Ranking.NONE) {
                continue;
            } else if (ranking == Ranking.SECOND) {
                System.out.printf(BONUS_STATISTICS_MESSAGE,
                        ranking.getMatchingCount(), ranking.getPrize(), count);
                continue;
            }

            System.out.printf(STATISTICS_MESSAGE,
                    ranking.getMatchingCount(), ranking.getPrize(), count);
        }
    }
}
