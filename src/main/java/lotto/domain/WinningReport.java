package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningReport {
    private final Map<Winning, Integer> winningCounts;

    public WinningReport(List<Winning> winnings) {
        this.winningCounts = new HashMap<>();
        initCounts();
        count(winnings);
    }

    private void initCounts() {
        for (Winning value : Winning.values()) {
            winningCounts.put(value, 0);
        }
    }

    private void count(List<Winning> winnings) {
        for (Winning winning : winnings) {
            increaseCountOf(winning);
        }
    }

    private void increaseCountOf(Winning winning) {
        winningCounts.put(winning, winningCounts.get(winning) + 1);
    }

    public Map<Winning, Integer> getWinningCounts() {
        return Map.copyOf(winningCounts);
    }
}
