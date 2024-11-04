package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PURCHASED_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATISTICS_HEADER = "당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void displayPurchasedLottos(List<Lotto> lottos) {
        System.out.printf((PURCHASED_MESSAGE) + "%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void displayResults(Map<Rank, Integer> rankResults) {
        System.out.println(STATISTICS_HEADER);
        System.out.println(SEPARATOR);

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                int count = rankResults.getOrDefault(rank, 0);
                System.out.println(rank.getMatchCount() + "개 일치" +
                        (rank.isBonusMatch() ? ", 보너스 볼 일치" : "") +
                        " (" + rank.getFormattedPrize() + ") - " + count + "개");
            }
        }
    }

    public static void displayProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, Math.round(profitRate * 10) / 10.0);
    }
}
