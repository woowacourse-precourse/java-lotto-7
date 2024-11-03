package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(LottoResult result, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Integer, Integer> rankCounts = result.getRankCounts();
        System.out.println("3개 일치 (5,000원) - " + rankCounts.getOrDefault(5, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCounts.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCounts.getOrDefault(3, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCounts.getOrDefault(2, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCounts.getOrDefault(1, 0) + "개");

        double profitRate = result.calculateProfitRate(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
