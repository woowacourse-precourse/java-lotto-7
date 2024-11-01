package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Integer> winningStatistics;

    public WinningStatistics(Map<Rank, Integer> winningStatistics) {
        this.winningStatistics = new HashMap<>();
        initializeWinningStatistics();
    }

    private void initializeWinningStatistics() {
        for (Rank rank : Rank.values()) {
            winningStatistics.put(rank, 0);
        }
    }
}
