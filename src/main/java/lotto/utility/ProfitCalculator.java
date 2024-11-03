package lotto.utility;

import java.math.BigDecimal;
import java.util.Map;

public class ProfitCalculator {
    public static BigDecimal calculate(int purchaseCost, Map<String, Integer> matchedCount) {
        long revenue = matchedCount.get(MatchedCountNameEnum.THREE_MATCHED.getMessage()) * LottoPrizeEnum.THREE_MATCHED_PRIZE.getAmount()
                + matchedCount.get(MatchedCountNameEnum.FOUR_MATCHED.getMessage()) * LottoPrizeEnum.FOUR_MATCHED_PRIZE.getAmount()
                + matchedCount.get(MatchedCountNameEnum.FIVE_MATCHED.getMessage()) * LottoPrizeEnum.FIVE_MATCHED_PRIZE.getAmount()
                + matchedCount.get(MatchedCountNameEnum.FIVE_WITH_BONUS_MATCHED.getMessage()) * LottoPrizeEnum.FIVE_WITH_BONUS_MATCHED_PRIZE.getAmount()
                + matchedCount.get(MatchedCountNameEnum.SIX_MATCHED.getMessage()) * LottoPrizeEnum.SIX_MATCHED_PRIZE.getAmount();

        double profit = (revenue / (double)purchaseCost) * 100;
        double profitRate = Math.round(profit * 10.0) / 10.0;

        return new BigDecimal(profit);
    }
}
