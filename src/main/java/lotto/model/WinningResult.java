package lotto.model;

import java.util.HashMap;

public class WinningResult {
    private final HashMap<Reward, Integer> rankCount = new HashMap<>();

    public void put(Reward reward) {
        rankCount.put(reward, rankCount.getOrDefault(reward,0)+1);
    }

    public HashMap<Reward, Integer> getRankCount() {
        return rankCount;
    }
}
