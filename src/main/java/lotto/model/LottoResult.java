package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRanking, Integer> rankingCount = new EnumMap<>(LottoRanking.class);

    public LottoResult() {
        for (LottoRanking ranking : LottoRanking.values()) {
            rankingCount.put(ranking, 0);
        }
    }

    public void addRanking(LottoRanking ranking) {
        rankingCount.put(ranking, rankingCount.get(ranking) + 1);
    }

    public Map<LottoRanking, Integer> getRankingCount() {
        return Map.copyOf(rankingCount);
    }

    public int getTotalPrize() {
        return rankingCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}