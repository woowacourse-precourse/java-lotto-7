package lotto.utility;

import java.util.Map;

public class ProfitCalculator {
    public static double calculate(int purchaseCost, Map<String, Integer> matchedCount) {
        int revenue = matchedCount.get("threeMatched") * 5000
                + matchedCount.get("fourMatched") * 50000
                + matchedCount.get("fiveMatched") * 1500000
                + matchedCount.get("fiveWithBonusMatched") * 30000000
                + matchedCount.get("sixMatched") * 2000000000;

        double profit = (revenue / (double)purchaseCost) * 100;
        return Math.round(profit * 10.0) / 10.0;
    }
}
