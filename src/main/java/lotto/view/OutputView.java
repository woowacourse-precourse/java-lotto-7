package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;

import java.util.List;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printResult(LottoResult result, int purchaseAmount) {
        printWinningStatistics(result);
        printProfitRate(result, purchaseAmount);
    }

    private static void printWinningStatistics(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoRank rank : LottoRank.values()) {
            int count = result.getRankCounts().getOrDefault(rank, 0);

            if (rank == LottoRank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n",
                        rank.getMatchCount(),
                        rank.getPrize(),
                        count);
                continue;
            }

            if (rank != LottoRank.NONE) {
                System.out.printf("%d개 일치 (%,d원) - %d개%n",
                        rank.getMatchCount(),
                        rank.getPrize(),
                        count);
            }
        }
    }

    private static void printProfitRate(LottoResult result, int purchaseAmount) {
        double profitRate = (result.getTotalPrize() / (double) purchaseAmount) * 100;
        profitRate = Math.round(profitRate * 10.0) / 10.0;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}