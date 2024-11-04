package lotto.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningResult {
    private HashMap<Reward, Integer> rankCount;

    public void put(Reward reward) {
        rankCount.put(reward, rankCount.getOrDefault(reward,0)+1);
    }

    public WinningResult() {
        rankCount = new LinkedHashMap<>() {{
            put(Reward.FIRST, 0);
            put(Reward.SECOND, 0);
            put(Reward.THIRD, 0);
            put(Reward.FOURTH, 0);
            put(Reward.FIFTH, 0);
            put(Reward.NONE, 0);
        }};
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
