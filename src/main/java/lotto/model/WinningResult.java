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
}
