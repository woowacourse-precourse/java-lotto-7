package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinningCount {
    private Map<Prize, Integer> winningCount;

    public WinningCount() {
        this.winningCount = new HashMap<>();
        Arrays.stream(Prize.values())
                .forEach(prize -> this.winningCount.put(prize, 0));
    }

    public void increaseCount(Prize prize) {
        this.winningCount.put(prize, this.winningCount.get(prize) + 1);
    }

    public Map<Prize, Integer> getWinningCount() {
        return new HashMap<>(winningCount);
    }
}
