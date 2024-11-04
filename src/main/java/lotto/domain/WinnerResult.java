package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinnerResult {

    private static final int INITIAL_VALUE = 0;
    private final Map<Winners, Integer> winnerAmounts = new EnumMap<>(Winners.class);

    public WinnerResult() {
        for (Winners winner : Winners.values()) {
            winnerAmounts.put(winner, INITIAL_VALUE); // 초기값 설정
        }
    }

    public void addMatchedAmount(Winners winner) {
        winnerAmounts.put(winner, winnerAmounts.get(winner) + 1);
    }

    public int getAmount(Winners winner) {
        return winnerAmounts.get(winner);
    }
}
