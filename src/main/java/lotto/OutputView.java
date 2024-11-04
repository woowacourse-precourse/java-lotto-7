package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printStatistics(Map<Rank, Integer> result, int purchaseAmount) {
        System.out.println("\n당첨 통계\n---");
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            int count = result.getOrDefault(rank, 0);
            System.out.println(rank.getMessage() + " - " + count + "개");
            totalPrize += rank.getPrize() * count;
        }
        double profit = (double) totalPrize / purchaseAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profit);
    }
}