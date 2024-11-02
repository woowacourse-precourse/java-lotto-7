package lotto.controller;

import java.util.Map;
import java.util.Map.Entry;
import lotto.model.Rank;

public class CalculateProfit {
    static double calculateProfit(Map<Rank, Integer> resultMap, int purchaseAmount) {
        double totalPrize = 0;

        for (Entry<Rank, Integer> rankIntegerEntry : resultMap.entrySet()) {
            Rank rank = rankIntegerEntry.getKey();
            int count = rankIntegerEntry.getValue();
            totalPrize += rank.getPrize() * count;
        }

        return totalPrize / purchaseAmount * 100;
    }
}