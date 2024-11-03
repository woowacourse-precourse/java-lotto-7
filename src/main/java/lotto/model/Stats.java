package lotto.model;

import lotto.LottoMatchState;

import java.util.HashMap;
import java.util.Map;

public class Stats {
    private final Map<LottoMatchState, Integer> winningDetail = new HashMap<>();

    public Map<LottoMatchState, Integer> getWinningDetail() {
        return winningDetail;
    }

    public void addWinningCount(LottoMatchState matchingState) {
        winningDetail.put(matchingState, winningDetail.getOrDefault(matchingState, 0) + 1);
    }

    public double getProfitRate(int purchaseAmount) {
        double allProfit = 0;
        for (Map.Entry<LottoMatchState, Integer> entry : winningDetail.entrySet()) {
            allProfit += entry.getKey().getMoney() * entry.getValue();
        }
        return (allProfit / purchaseAmount * 100);
    }
}
