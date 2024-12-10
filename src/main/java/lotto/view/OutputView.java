package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResults(Map<Rank, Integer> rankCounts, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            System.out.printf("%s - %d개%n", rank, rankCounts.getOrDefault(rank, 0));
        }
        System.out.println("총 수익률은 " + String.format("%.1f%%", profitRate) + "입니다.");
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
