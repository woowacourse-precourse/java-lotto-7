package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts = new HashMap<>();

    public LottoResult() {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addResult(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public int getTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }
}
