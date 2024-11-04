package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private Map<WinningType, Integer> winningResult = new HashMap<>();

    public void addResult(WinningType type) {
        winningResult.put(type, winningResult.getOrDefault(type, 0) + 1);
    }

    public Map<WinningType, Integer> getWinningResult(){
        return Map.copyOf(winningResult);
    }
}
