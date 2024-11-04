package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputHandler {
    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_TITLE = "당첨 통계\n---";
    private static final String MATCH_COUNT_STATISTICS_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_PLACE_STATISTICS_FORMAT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %s%%입니다.";

    public void printLottoNumbers(int purchaseCount, List<List<Integer>> lottoNumbers) {
        System.out.printf((PURCHASE_COUNT_MESSAGE) + "%n", purchaseCount);
        for (List<Integer> numbers : lottoNumbers) {
            numbers.sort(Integer::compareTo);
            System.out.println(numbers);
        }
    }

    public void printWinningStatistics(Map<WinningRank, Integer> statistics) {
        System.out.println(WINNING_STATISTICS_TITLE);

        for (WinningRank rank : WinningRank.values()) {
            int count = statistics.getOrDefault(rank, 0);
            printRankStatistics(rank, count);
        }
    }

    private void printRankStatistics(WinningRank rank, int count) {
        if (rank.isRequiresBonus()) {
            System.out.printf((SECOND_PLACE_STATISTICS_FORMAT) + "%n", count);
            return;
        }
        System.out.printf((MATCH_COUNT_STATISTICS_FORMAT) + "%n",
                rank.getMatchCount(), formatPrize(rank.getPrize()), count);
    }

    public void printYield(double yield) {
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.printf((TOTAL_YIELD_MESSAGE) + "%n", df.format(yield));
    }

    private String formatPrize(int prize) {
        return String.format("%,d", prize);
    }
}
