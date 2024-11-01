package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private Map<Rank, Integer> result;

    public WinningResult() {
        this.result = new EnumMap<>(Rank.class);
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public void add(Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }
}