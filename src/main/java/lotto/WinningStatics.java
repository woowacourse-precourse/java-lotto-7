package lotto;

import java.util.EnumMap;
import java.util.Map;

public class WinningStatics {
    private final Map<Rank, Integer> winningCount = new EnumMap<>(Rank.class);

    public WinningStatics() {
        for (Rank rank : Rank.values()) {
            winningCount.put(rank, 0);
        }
    }

    public void addWinning(Rank rank) {
        winningCount.put(rank, winningCount.get(rank) + 1);
    }

    public int getWinningCount(Rank rank) {
        return winningCount.get(rank);
    }

    public long getPrizeAmount() {
        long totalPrizeAmount = 0;
        for (Rank rank : Rank.values()) {
            totalPrizeAmount += rank.getPrize() * winningCount.get(rank);
        }
        return totalPrizeAmount;
    }
}
