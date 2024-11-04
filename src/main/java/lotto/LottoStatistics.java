package lotto;

import java.util.Map;

public class LottoStatistics {

    public double calculateYield(Map<WinningRank, Integer> results, int purchaseAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }
}
