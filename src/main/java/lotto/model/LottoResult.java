package lotto.model;

import java.util.EnumMap;
import java.util.Map;
import lotto.common.LottoRank;

public record LottoResult(Map<LottoRank, Integer> results) {
    public LottoResult {
        results = new EnumMap<>(results);
    }

    public static LottoResult initialize() {
        Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, 0);
        }
        return new LottoResult(results);
    }

    public LottoResult addResult(LottoRank rank) {
        Map<LottoRank, Integer> newResults = new EnumMap<>(results);
        newResults.put(rank, results.getOrDefault(rank, 0) + 1);
        return new LottoResult(newResults);
    }

    public int getWinningCount(LottoRank rank) {
        return results.getOrDefault(rank, 0);
    }
}