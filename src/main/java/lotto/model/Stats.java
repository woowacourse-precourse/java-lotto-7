package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Stats {
    private final Map<String, Integer> winningDetail = new HashMap<>();

    public Map<String, Integer> getWinningDetail() {
        return winningDetail;
    }

    public void addWinningCount(String matchingState) {
        winningDetail.put(matchingState, winningDetail.getOrDefault(matchingState, 0) + 1);
    }
}
