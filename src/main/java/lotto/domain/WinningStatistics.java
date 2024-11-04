package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningStatistics {

    private final Map<WinningRank, Integer> statistics;

    public WinningStatistics() {
        this.statistics = new LinkedHashMap<>();
        for (WinningRank rank : WinningRank.values()) {
            this.statistics.put(rank, 0);
        }
    }

    public void incrementRankCount(WinningRank rank) {
        this.statistics.put(rank, statistics.get(rank) + 1);
    }

    public Map<WinningRank, Integer> getStatistics() {
        return statistics;
    }
    
}
