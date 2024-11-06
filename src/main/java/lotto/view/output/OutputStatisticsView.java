package lotto.view.output;

import java.util.Map;
import lotto.model.Rank;

public class OutputStatisticsView {
    public static void lottoResultOutput(Map<Rank, Integer> ranks) {
        System.out.println("당첨 통계\n---");

        for (Map.Entry<Rank, Integer> entry : ranks.entrySet()) {
            Rank rank = entry.getKey();
            if (rank == Rank.NONE) {
                continue;
            }
            long count = entry.getValue();
            System.out.printf("%s%d개\n", rank.getMessage(), count);
        }
    }

    public static void statisticsOutput(double result) {
        System.out.printf("총 수익률은 %.1f%%입니다.", result);
    }
}
