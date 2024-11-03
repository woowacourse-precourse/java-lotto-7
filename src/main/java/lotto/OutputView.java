package lotto;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printPurchasedLottos(Lottos lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottos.size());
        System.out.println(String.join("\n", lottos.getAllLottoNumbers()));
    }

    public static void printWinningStatistics(LottoResult result) {
        System.out.println("당첨 통계\n---");

        for (LottoRanking ranking : LottoRanking.values()) {
            if (ranking != LottoRanking.NONE) {
                System.out.printf("%s - %d개\n", ranking.getMessage(), result.getResultCount(ranking));
            }
        }
    }
}
