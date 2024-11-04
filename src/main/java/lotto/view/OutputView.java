package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PURCHASED_MESSAGE = "%d개를 구매했습니다.";
    private static final String RESULT_HEADER = "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String MATCH_COUNT_MESSAGE = "%d개 일치 (%d원) - %d개";
    private static final String SECOND_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치 (%d원) - %d개";

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(String.format(PURCHASED_MESSAGE, lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(Map<Rank, Integer> results, double profitRate) {
        System.out.println();
        System.out.println(RESULT_HEADER);
        System.out.println(DIVIDER);
        printRankResult(results, Rank.FIFTH);
        printRankResult(results, Rank.FOURTH);
        printRankResult(results, Rank.THIRD);
        printRankResult(results, Rank.SECOND);
        printRankResult(results, Rank.FIRST);
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }

    private static void printRankResult(Map<Rank, Integer> results, Rank rank) {
        int count = results.getOrDefault(rank, 0);
        if (rank == Rank.SECOND) {
            System.out.println(String.format(SECOND_MATCH_MESSAGE, rank.getPrize(), count));
            return;
        }
        System.out.println(String.format(MATCH_COUNT_MESSAGE, rank.getMatchCount(), rank.getPrize(), count));
    }
}