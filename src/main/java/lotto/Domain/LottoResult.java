package lotto.Domain;

import java.util.EnumMap;
import java.util.Map;
import lotto.Enum.LottoPrizeRank;

public class LottoResult {
    private final Map<LottoPrizeRank, Integer> results;

    public LottoResult() {
        this.results = initializeResults();
    }

    private Map<LottoPrizeRank, Integer> initializeResults() {
        Map<LottoPrizeRank, Integer> initialResults = new EnumMap<>(LottoPrizeRank.class);
        for (LottoPrizeRank rank : LottoPrizeRank.values()) {
            initialResults.put(rank, 0);
        }
        return initialResults;
    }

    public void addResult(LottoPrizeRank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public int getWinningCount(LottoPrizeRank rank) {
        return results.get(rank);
    }

    public Map<LottoPrizeRank, Integer> getResults() {
        return new EnumMap<>(results);
    }
}

