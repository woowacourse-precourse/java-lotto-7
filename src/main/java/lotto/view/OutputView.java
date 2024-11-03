package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.enums.Stats;

public class OutputView {
    private static final String PURCHASED_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATS_MESSAGE = "당첨 통계\n---";

    public static final void purchaseCount(int purchaseCount) {
        System.out.println();
        System.out.println(purchaseCount + PURCHASED_COUNT_MESSAGE);
    }

    public static final void lottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static final void Stats(Map<Stats, Integer> statsCount) {
        System.out.println();
        System.out.println(WINNING_STATS_MESSAGE);

        for (Stats stat : Stats.values()) {
            int count = statsCount.getOrDefault(stat, 0);
            System.out.println(stat.getDescription() + count + "개");
        }
    }
}
