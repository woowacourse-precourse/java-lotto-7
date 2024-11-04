package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> results = new HashMap<>();

    public void addResult(LottoRank rank) {
        results.put(rank, results.getOrDefault(rank, 0) + 1);
    }

    public Map<LottoRank, Integer> getResults() {
        return results;
    }

    public double calculateYield(int purchaseAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }
}