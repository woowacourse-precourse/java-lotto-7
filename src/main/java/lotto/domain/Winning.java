package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class Winning {

    private Map<Rank, Integer> winningCount;

    public Winning() {
        winningCount = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            winningCount.put(rank, 0);
        }
    }

    public void increaseWinningCount(Rank rank) {
        winningCount.put(rank, winningCount.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return winningCount.get(rank);
    }

}
