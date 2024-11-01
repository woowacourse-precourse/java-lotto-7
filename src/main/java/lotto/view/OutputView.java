package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Win;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printWinningStatistics(Win statistics, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<Rank, Integer> stats = statistics.getStatistics();

        System.out.printf("3개 일치 (5,000원) - %d개\n", stats.getOrDefault(Rank.FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", stats.getOrDefault(Rank.FOURTH, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", stats.getOrDefault(Rank.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", stats.getOrDefault(Rank.SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", stats.getOrDefault(Rank.FIRST, 0));

        double yield = statistics.calculateRate(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}
