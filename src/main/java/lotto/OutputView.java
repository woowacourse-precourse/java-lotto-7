package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLottoTickets(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResult(Result result, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        printRankResults(result.getRankCountMap());
        printYield(result.getYield(purchaseAmount));
    }

    private static void printRankResults(Map<Rank, Integer> rankCountMap) {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }
            System.out.println(rank + " - " + rankCountMap.get(rank) + "개");
        }
    }

    private static void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}