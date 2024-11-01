package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String MATCH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String MATCH_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String TOTAL_RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf((PURCHASE_MESSAGE) + "%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningStatistics(Map<LottoRank, Integer> statistics) {
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(DIVIDER);

        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NO_PRIZE) continue;
            int matchCount = rank.getMatchCount();
            String prizeAmount = rank.getFormatPrize();
            int count = statistics.getOrDefault(rank, 0);
            System.out.println(WinningStatisticsMessage(rank,matchCount,prizeAmount,count));
        }
    }

    private static String WinningStatisticsMessage(LottoRank rank, int matchCount, String prizeAmount, int count) {
        if (rank == LottoRank.SECOND_PRIZE) {
            return String.format(MATCH_BONUS_MESSAGE, matchCount, prizeAmount, count);
        }
        return String.format(MATCH_MESSAGE, matchCount, prizeAmount, count);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(TOTAL_RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}
