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

        System.out.printf("3개 일치 (5,000원) - %d개%n", prizeCount.getOrDefault(LottoRank.FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) - %d개%n", prizeCount.getOrDefault(LottoRank.FOURTH, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", prizeCount.getOrDefault(LottoRank.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", prizeCount.getOrDefault(LottoRank.SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", prizeCount.getOrDefault(LottoRank.FIRST, 0));

        System.out.printf("총 수익률은 %.1f%%입니다.%n", calculateProfitRate(totalSpent));
    }
}
