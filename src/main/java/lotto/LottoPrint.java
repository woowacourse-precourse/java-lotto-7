package lotto;

import java.util.List;
import java.util.Map;

public class LottoPrint {
    public static final int PROBABILITY_CALCULATION = 100;
    public static int TOTAL_PRIZE = 0;

    public static void purchaseNumber(int lottoQuantity, List<Lotto> lottoRepository) {
        System.out.println(lottoQuantity + "개를 구매했습니다.");
        for (Lotto lotto : lottoRepository) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void getTotalPrize(Map<LottoRank, Integer> rankStatistics ) {
        for (LottoRank rank : LottoRank.values()) {
            int count = rankStatistics .get(rank);
            System.out.printf(rank.getPrintFormat() + "\n", rank.getMatchCount(), rank.getPrize(), count);
            TOTAL_PRIZE += count * rank.getPrize();
        }
    }

    public static void printGrossMargin(int purchasePrice) {
        double grossMargin = (double) TOTAL_PRIZE / purchasePrice * PROBABILITY_CALCULATION;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", grossMargin);
    }

}