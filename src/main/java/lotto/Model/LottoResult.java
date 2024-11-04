package lotto.Model;

import java.util.EnumMap;

public class LottoResult {
    private final EnumMap<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);

    public void addResult(LottoRank rank) {
        results.put(rank, results.getOrDefault(rank, 0) + 1);
    }

    public EnumMap<LottoRank, Integer> getResults() {
        return results;
    }
}
