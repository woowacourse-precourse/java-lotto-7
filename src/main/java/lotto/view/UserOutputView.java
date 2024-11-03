package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class UserOutputView {

    private static final String STATISTICS_MESSAGE = "당첨 통계";
    private static final String STATISTICS_DIVIDER = "---";

    public static void outputLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void outputWinningStatistics(Map<Rank, Integer> statistics) {
        System.out.println(STATISTICS_MESSAGE);
        System.out.println(STATISTICS_DIVIDER);

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) continue; // Skip "낙첨" rank

            int count = statistics.getOrDefault(rank, 0);
            System.out.println(rank.getDescription() + " - " + count + "개");
        }
    }

    public static void outputProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
