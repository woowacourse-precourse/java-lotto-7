package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TICKET_NUMBER_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";
    private static final String RANK_RESULT_MESSAGE = "%s - %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public void printLottoCount(int number) {
        System.out.printf(TICKET_NUMBER_MESSAGE, number);
    }

    public void printLottoNumber(List<Lotto> issuedLotto) {
        for (Lotto lotto : issuedLotto) {
            System.out.println(lotto);
        }
    }

    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
    }

    public void printResult(Map<Rank, Long> rankCount) {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }

            Long count = rankCount.getOrDefault(rank, 0L);
            String rankContent = rank.getRankContent();

            printRankResult(rankContent, count);
        }
    }

    private void printRankResult(String rankContent, Long number) {
        System.out.printf(RANK_RESULT_MESSAGE, rankContent, number);
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }
}
