package lotto;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LottoStatistics {
    private final Map<LottoRank, Integer> prizeCount = new HashMap<>();

    public LottoStatistics() {
        for (LottoRank rank : LottoRank.values()) {
            prizeCount.put(rank, 0);
        }
    }

    public void addResult(LottoRank rank) {
        prizeCount.put(rank, prizeCount.get(rank) + 1);
    }

    public double calculateProfitRate(int totalSpent) {
        int totalPrize = prizeCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return Math.round((double) totalPrize / totalSpent * 1000) / 10.0;
    }

    public void printStatistics(int totalSpent) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.MISS) {
                System.out.printf("%d개 일치 (%d원) - %d개%n",
                        rank.getMatchedCount(), rank.getPrize(), prizeCount.get(rank));
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", calculateProfitRate(totalSpent));
    }
}
