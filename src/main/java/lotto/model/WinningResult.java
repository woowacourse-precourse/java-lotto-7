package lotto.model;

import java.util.HashMap;

public class WinningResult {
    private final HashMap<Reward, Integer> rankCount = new HashMap<>();

    public void put(Reward reward) {
        rankCount.put(reward, rankCount.getOrDefault(reward,0)+1);
    }

    public double getProfitRate(Amount amount){
        double totalProfit = 0;
        for (Reward reward : rankCount.keySet()) {
            totalProfit += reward.getPrize() * rankCount.get(reward);
        }
        return totalProfit * 100 / (float) amount.getAmount();
    }

    public HashMap<Reward, Integer> getRankCount() {
        return rankCount;
    }
}
