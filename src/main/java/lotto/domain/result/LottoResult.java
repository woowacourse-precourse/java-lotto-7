package lotto.domain.result;

import lotto.domain.model.LottoRank;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private static final int DEFAULT_RANK_COUNT = 0;

    private final Map<LottoRank, Integer> results;

    public LottoResult(Map<LottoRank, Integer> results) {
        this.results = new EnumMap<>(results);
    }

    public int getRankCount(LottoRank rank) {
        return results.getOrDefault(rank, DEFAULT_RANK_COUNT);
    }

    public Map<LottoRank, Integer> getResults() {
        return new EnumMap<>(results);
    }
}