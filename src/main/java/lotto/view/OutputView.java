package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.PrizeRank;

public class OutputView {
    public void printLottos(int purchaseAmount, List<Lotto> lottos) {
        System.out.println("\n" + purchaseAmount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public void printPrizeStats(Map<PrizeRank, Integer> prizeRankCounts, double rateOfReturn) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prizeRankCounts.get(PrizeRank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeRankCounts.get(PrizeRank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeRankCounts.get(PrizeRank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeRankCounts.get(PrizeRank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeRankCounts.get(PrizeRank.FIRST) + "개");
        System.out.println("총 수익률은 "+ String.format("%.1f", rateOfReturn) +"%입니다.");
    }
}
