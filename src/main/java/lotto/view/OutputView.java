package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Ranking;

public class OutputView {

    private OutputView() {}

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printRankCounts(Map<Ranking, Integer> rankCounts) {
        System.out.println();
        System.out.println("당첨 통계\n---");
        for (Ranking ranking : Ranking.values()) {
            if (ranking != Ranking.LOSE) {
                String output = formatRankingOutput(ranking, rankCounts.getOrDefault(ranking, 0));
                printFormattedRank(output);
            }
        }
    }

    private static String formatRankingOutput(Ranking ranking, int count) {
        if (ranking == Ranking.SECOND_PLACE) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", ranking.numberOfHits,
                    String.format("%,d", ranking.award), count);
        }
        return String.format("%d개 일치 (%s원) - %d개", ranking.numberOfHits, String.format("%,d", ranking.award), count);
    }

    private static void printFormattedRank(String output) {
        System.out.println(output);
    }

    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
