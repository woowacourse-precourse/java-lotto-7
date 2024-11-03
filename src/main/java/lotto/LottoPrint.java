package lotto;

import java.util.List;
import java.util.Map;

public class LottoPrint {

    private static int totalPrize = 0;

    public static void purchaseNumber(int lottoQuantity, List<Lotto> lottoRepository) {
        System.out.println(lottoQuantity + "개를 구매했습니다.");
        for (Lotto lotto : lottoRepository) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void getTotalPrize(Map<LottoRank, Integer> winningStatistics) {
        for (LottoRank rank : LottoRank.values()) {
            int count = winningStatistics.get(rank);
            System.out.printf(rank.getPrintFormat() + "\n", rank.getMatchCount(), rank.getPrize(), count);
            totalPrize += count * rank.getPrize();
        }
    }

    public static void extracted(int purchasePrice) {
        double grossMargin = (double) totalPrize / purchasePrice * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", grossMargin);
    }

}
