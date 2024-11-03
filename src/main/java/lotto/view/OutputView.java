package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Ranking;

public class OutputView {

    public static void printLottoPurchaseCount(int lottoPurchaseCount) {
        System.out.println(lottoPurchaseCount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printLottoResult(Map<Ranking, Integer> rankingCountMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rankingCountMap.getOrDefault(Ranking.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + rankingCountMap.getOrDefault(Ranking.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankingCountMap.getOrDefault(Ranking.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankingCountMap.getOrDefault(Ranking.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankingCountMap.getOrDefault(Ranking.FIRST, 0) + "개");
    }

    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
