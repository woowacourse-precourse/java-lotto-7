package lotto.domain.result;

import lotto.domain.model.LottoRank;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> results;

    public LottoResult(Map<LottoRank, Integer> results) {
        this.results = new EnumMap<>(results);
    }

    public int getRankCount(LottoRank rank) {
        return results.getOrDefault(rank, 0);
    }

    public Map<LottoRank, Integer> getResults() {
        return new EnumMap<>(results);
    }
}