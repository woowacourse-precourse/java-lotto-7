package lotto;

import java.util.EnumMap;
import java.util.Map;

public class WinningCounter {
    private final Map<Winning, Integer> winningCount;

    public WinningCounter() {
        winningCount = new EnumMap<>(Winning.class);
        for (Winning winning : Winning.values()) {
            winningCount.put(winning, 0);
        }
    }

    public int calculateProfitAmount() {
        int profitAmount = 0;
        for (Map.Entry<Winning, Integer> count : winningCount.entrySet()) {
            profitAmount += count.getKey().getWinningAmount() * count.getValue();
        }
        return profitAmount;
    }

    public void addWinning(Winning winning) {
        winningCount.put(winning, winningCount.get(winning) + 1);
    }

    public int getWinningCount(Winning winning) {
        return winningCount.get(winning);
    }
}
