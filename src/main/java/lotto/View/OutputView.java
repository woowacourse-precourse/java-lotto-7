package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.LottoRank;
import lotto.Model.LottoResult;

import java.util.List;

public class OutputView {

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getNumbers());
        }
    }

    public static void printResult(LottoResult result) {
        System.out.println("\n당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.SECOND && rank != LottoRank.NONE) {
                System.out.printf("%d개 일치 (%,d원) - %d개\n", rank.getMatchCount(), rank.getPrize(), result.getResults().getOrDefault(rank, 0));
            }
            if (rank == LottoRank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", rank.getMatchCount(), rank.getPrize(), result.getResults().getOrDefault(rank, 0));
            }
        }
    }

    public static void printProfit(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
