package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLottoPurchaseInfo(int numberOfLottos, List<Lotto> lottos) {
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
    
    
    public static void printWinningStatistics(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> rankCounts = result.getRankCounts();
        for (Rank rank : Rank.SORTED_RANKS) {
            int count = rankCounts.getOrDefault(rank, 0);
            System.out.printf("%d개 일치", rank.getMatchCount());
            if (rank.isMatchBonus()) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.printf(" (%s원) - %d개\n", rank.getFormattedPrize(), count);
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }

}