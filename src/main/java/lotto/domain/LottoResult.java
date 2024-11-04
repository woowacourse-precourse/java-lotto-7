package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> statistics = new HashMap<>();

    public void addResult(Rank rank) {
        statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
    }

    public void printStatistics() {
        System.out.println("\n당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            int count = statistics.getOrDefault(rank, 0);
            System.out.printf("%s - %d개\n", rank.getDescription(), count);
        }
    }

    public double calculateEarningsRate(int totalPurchaseAmount) {
        int totalEarnings = statistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalEarnings / totalPurchaseAmount * 100;
    }
}
