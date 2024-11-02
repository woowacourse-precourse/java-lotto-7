package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedMap;

public class LottoStatistics {
    private final SequencedMap<Rank, Integer> results;

    public LottoStatistics() {
        this.results = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getResults() {
        return Map.copyOf(results);
    }

}