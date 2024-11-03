package lotto.model;

import java.util.HashMap;

public class WinningResult {
    private final HashMap<Integer, Integer> rankCount = new HashMap<>();

    public void put(int rank) {
        rankCount.put(rank, rankCount.getOrDefault(rank,0)+1);
    }

    public HashMap<Integer, Integer> getRankCount() {
        return rankCount;
    }
}
