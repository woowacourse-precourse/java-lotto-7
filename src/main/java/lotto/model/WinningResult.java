package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> results = new EnumMap<>(Rank.class);

    public WinningResult() {
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public void addResult(Rank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return results.get(rank);
    }
}
