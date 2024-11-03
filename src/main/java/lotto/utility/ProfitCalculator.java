package lotto.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

public class ProfitCalculator {
    public static String calculate(int purchaseCost, Map<String, Integer> matchedCount) {
        long revenue = (long)matchedCount.get(MatchedCountNameEnum.THREE_MATCHED.getMessage()) * LottoPrizeEnum.THREE_MATCHED_PRIZE.getAmount()
                + (long)matchedCount.get(MatchedCountNameEnum.FOUR_MATCHED.getMessage()) * LottoPrizeEnum.FOUR_MATCHED_PRIZE.getAmount()
                + (long)matchedCount.get(MatchedCountNameEnum.FIVE_MATCHED.getMessage()) * LottoPrizeEnum.FIVE_MATCHED_PRIZE.getAmount()
                + (long)matchedCount.get(MatchedCountNameEnum.FIVE_WITH_BONUS_MATCHED.getMessage()) * LottoPrizeEnum.FIVE_WITH_BONUS_MATCHED_PRIZE.getAmount()
                + (long)matchedCount.get(MatchedCountNameEnum.SIX_MATCHED.getMessage()) * LottoPrizeEnum.SIX_MATCHED_PRIZE.getAmount();

        double profit = (revenue / (double)purchaseCost) * 100;
        BigDecimal profitRate = new BigDecimal(profit).setScale(1, RoundingMode.HALF_UP);

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(profitRate);
    }
}
