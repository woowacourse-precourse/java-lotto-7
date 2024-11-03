package lotto.domain;

import java.util.Map;
import java.util.EnumMap;
import lotto.constant.Rank;

public class LottoResult {
    private final Map<Rank, Integer> winningCount = new EnumMap<>(Rank.class);
    private long totalWinnings = 0;

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            winningCount.put(rank, 0);
        }
    }

    public void recordMatch(Rank rank) {
        winningCount.put(rank, winningCount.get(rank) + 1);
        totalWinnings += rank.getWinnings();
    }

    public Map<Rank, Integer> getWinningCount() {
        return winningCount;
    }

    public long getTotalWinnings() {
        return totalWinnings;
    }
}
