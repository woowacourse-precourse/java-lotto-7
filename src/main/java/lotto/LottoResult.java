package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> results = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public void updateStatistics(int matchCount, boolean bonusMatch) {
        Rank rank = Rank.valueOf(matchCount, bonusMatch);
        results.put(rank, results.get(rank) + 1);
    }

    public void printStatistics(int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            System.out.printf("%s - %d개\n", rank.getDescription(), results.get(rank));
        }
        double totalWinnings = results.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        double yield = (totalWinnings / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}
