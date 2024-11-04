package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public static void printWinningStatistics(Map<LottoRank, Integer> results) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                System.out.printf("%s (%,d원) - %d개\n",
                        rank.getDescription(),
                        rank.getPrize(),
                        results.getOrDefault(rank, 0));
            }
        }
    }

    public static void printReturnRate(double returnRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}