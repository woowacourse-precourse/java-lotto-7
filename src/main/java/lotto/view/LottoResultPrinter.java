package lotto.view;

import java.util.Map;
import lotto.model.Rank;

public class LottoResultPrinter {
    private static final int LOTTO_PRICE = 1000;

    public void printResult(Map<Rank, Integer> resultCount, int totalPrize, long purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                        rank.getMatchCount(),
                        String.format("%,d", rank.getPrize()),
                        resultCount.getOrDefault(rank, 0));
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개\n",
                    rank.getMatchCount(),
                    String.format("%,d", rank.getPrize()),
                    resultCount.getOrDefault(rank, 0));

        }

        double profitRate = calculateProfitRate(totalPrize, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private double calculateProfitRate(int totalPrize, long purchaseAmount) {
        return (double) totalPrize / purchaseAmount * 100;
    }
}
