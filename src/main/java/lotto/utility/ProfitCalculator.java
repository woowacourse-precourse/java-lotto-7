package lotto.utility;

import java.util.Map;

public class ProfitCalculator {
    public static double calculate(int purchaseCost, Map<String, Integer> matchedCount) {
        int revenue = matchedCount.get("threeMatched") * LottoPrizeEnum.THREE_MATCHED_PRIZE.getAmount()
                + matchedCount.get("fourMatched") * LottoPrizeEnum.FOUR_MATCHED_PRIZE.getAmount()
                + matchedCount.get("fiveMatched") * LottoPrizeEnum.FIVE_MATCHED_PRIZE.getAmount()
                + matchedCount.get("fiveWithBonusMatched") * LottoPrizeEnum.FIVE_WITH_BONUS_MATCHED_PRIZE.getAmount()
                + matchedCount.get("sixMatched") * LottoPrizeEnum.SIX_MATCHED_PRIZE.getAmount();

        double profit = (revenue / (double)purchaseCost) * 100;
        return Math.round(profit * 10.0) / 10.0;
    }
}
