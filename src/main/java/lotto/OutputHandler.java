package lotto;

import java.util.List;
import java.util.Map;

public class OutputHandler {
    public static void displayPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void displayResults(Map<Rank, Integer> rankCounts, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                int count = rankCounts.get(rank);
                System.out.printf("%d개 일치", rank.getMatchCount());
                if (rank.isRequireBonus()) {
                    System.out.print(", 보너스 볼 일치");
                }
                System.out.printf(" (%,d원) - %d개\n", rank.getPrize(), count);
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}