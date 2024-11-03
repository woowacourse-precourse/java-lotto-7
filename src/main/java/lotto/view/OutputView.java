package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void displayPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void displayResults(Map<Rank, Integer> rankResults) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                int count = rankResults.getOrDefault(rank, 0);
                System.out.println(rank.getMatchCount() + "개 일치" +
                        (rank.isBonusMatch() ? ", 보너스 볼 일치" : "") +
                        " (" + rank.getPrize() + "원) - " + count + "개");
            }
        }
    }

    public static void displayProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
