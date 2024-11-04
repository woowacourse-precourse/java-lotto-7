package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private Map<WinningType, Integer> winningResult = new HashMap<>();

    public void addResult(WinningType type) {
        winningResult.put(type, winningResult.getOrDefault(type, 0) + 1);
    }

    public int getCount(WinningType type) {
        return winningResult.getOrDefault(type, 0);
    }

    public Map<WinningType, Integer> getWinningResult() {
        return Map.copyOf(winningResult);
    }

    public int calculateTotalPrize() {
        return winningResult.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
