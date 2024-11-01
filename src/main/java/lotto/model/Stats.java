package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Stats {
    private static final int THREE_MATCHING_PRICE = 5000;
    private static final int FOUR_MATCHING_PRICE = 50000;
    private static final int FIVE_MATCHING_PRICE = 1500000;
    private static final int FIVE_MATCHING_BONUS_PRICE = 30000000;
    private static final int SIX_MATCHING_PRICE = 2000000000;

    private final Map<String, Integer> winningDetail = new HashMap<>();

    public Map<String, Integer> getWinningDetail() {
        return winningDetail;
    }

    public void addWinningCount(String matchingState) {
        winningDetail.put(matchingState, winningDetail.getOrDefault(matchingState, 0) + 1);
    }

    public double getProfitRate(int purchaseAmount) {
        double allProfit = 0;
        allProfit += (winningDetail.getOrDefault("3", 0) * THREE_MATCHING_PRICE);
        allProfit += (winningDetail.getOrDefault("4", 0) * FOUR_MATCHING_PRICE);
        allProfit += (winningDetail.getOrDefault("5", 0) * FIVE_MATCHING_PRICE);
        allProfit += (winningDetail.getOrDefault("5+", 0) * FIVE_MATCHING_BONUS_PRICE);
        allProfit += (winningDetail.getOrDefault("6", 0) * SIX_MATCHING_PRICE);
        return (allProfit / purchaseAmount * 100);
    }
}
