package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinningCount {
    private Map<String, Integer> winningCount;

    public WinningCount() {
        this.winningCount = new HashMap<>();
        Arrays.stream(Profit.values())
                .forEach(profit -> this.winningCount.put(profit.name(), 0));
    }

    public void increaseCount(String key) {
        this.winningCount.put(key, this.winningCount.get(key) + 1);
    }

    public Map<String, Integer> getWinningCount() {
        return new HashMap<>(winningCount);
    }
}
