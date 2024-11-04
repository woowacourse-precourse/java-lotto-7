package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PrizeRank;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_TITLE = "\n당첨 통계\n---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printPurchaseResult(List<Lotto> lottos) {
        System.out.println(String.format(PURCHASE_RESULT_MESSAGE, lottos.size()));
        lottos.forEach(this::printLotto);
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void printWinningStatistics(Map<PrizeRank, Integer> statistics) {
        System.out.println(WINNING_STATISTICS_TITLE);

        for (PrizeRank rank : PrizeRank.values()) {
            if (rank != PrizeRank.NONE) {
                printPrizeResult(rank, statistics.get(rank));
            }
        }
    }

    private void printPrizeResult(PrizeRank rank, int count) {
        System.out.printf("%s (%,d원) - %d개%n",
                rank.getDescription(),
                rank.getPrizeMoney(),
                count);
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }
}
