package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.enums.Stats;

public class OutputView {
    private static final String PURCHASED_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATS_MESSAGE = "당첨 통계\n---";
    private static final String STAT_COUNT_MESSAGE = "%s%d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public static final void purchaseCount(int purchaseCount) {
        System.out.println();
        System.out.printf(PURCHASED_COUNT_MESSAGE, purchaseCount);
    }

    public static final void lottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static final void stats(Map<Stats, Integer> statsCount) {
        System.out.println();
        System.out.println(WINNING_STATS_MESSAGE);

        for (Stats stat : Stats.values()) {
            int count = statsCount.getOrDefault(stat, 0);
            System.out.printf(STAT_COUNT_MESSAGE, stat.getDescription(), count);
        }
    }

    public static final void profitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }
}
