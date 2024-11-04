package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import lotto.common.LottoRank;

public class LottoStatistics {
    private final Map<LottoRank, Integer> results;

    public LottoStatistics() {
        results = new TreeMap<>(Comparator.comparingInt(LottoRank::getPrize));
        Arrays.stream(LottoRank.values()).forEach(rank -> results.put(rank, 0));
    }

    public void recordResult(LottoRank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public double calculateProfitRate(int totalInvestment) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / totalInvestment * 100;
    }

    public Map<LottoRank, Integer> getResults() {
        return results;
    }
}
