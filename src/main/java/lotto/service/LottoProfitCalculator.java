package lotto.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static lotto.constant.LottoMatchConstant.*;

public class LottoProfitCalculator {
    private final int PERCENT_MULTIPLIER = 100;

    public double calculateRateOfReturn(LinkedHashMap<String, Integer> userStatistics, int purchaseAmount) {
        int totalPrize = calculateTotalPrize(userStatistics);

        return (double) totalPrize / purchaseAmount * PERCENT_MULTIPLIER;
    }

    private int calculateTotalPrize(LinkedHashMap<String, Integer> userStatistics) {
        Map<String, Integer> prizeMoney = new HashMap<>();
        prizeMoney.put(MATCH_3.getMatch(), 5000);
        prizeMoney.put(MATCH_4.getMatch(), 50000);
        prizeMoney.put(MATCH_5.getMatch(), 1500000);
        prizeMoney.put(MATCH_5_WITH_BONUS.getMatch(), 30000000);
        prizeMoney.put(MATCH_6.getMatch(), 2000000000);

        int totalPrize = 0;
        for (Map.Entry<String, Integer> entry : userStatistics.entrySet()) {
            String prizeGrade = entry.getKey();
            int count = entry.getValue();
            totalPrize += prizeMoney.getOrDefault(prizeGrade, 0) * count;
        }
        return totalPrize;
    }

}
