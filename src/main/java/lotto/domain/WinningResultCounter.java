package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningResultCounter {
    private final Map<WinningResult, Integer> winningResult;

    public WinningResultCounter() {
        this.winningResult = new LinkedHashMap<>();
        Arrays.stream(WinningResult.values())
                .forEach(result -> winningResult.put(result, 0));
    }

    public void increment(WinningResult result) {
        winningResult.put(result, winningResult.get(result) + 1);
    }

    public Map<WinningResult, Integer> getWinningResult() {
        return winningResult;
    }
}
