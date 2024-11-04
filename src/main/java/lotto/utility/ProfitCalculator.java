package lotto.utility;

import lotto.enumerate.LottoPrizeEnum;
import lotto.enumerate.MatchedCountKeyEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

public class ProfitCalculator {
    public static String calculate(int purchaseCost, Map<String, Integer> matchedCount) {
        long revenue = (long)matchedCount.get(MatchedCountKeyEnum.THREE_MATCHED.getKey()) * LottoPrizeEnum.THREE_MATCHED.getAmount()
                + (long)matchedCount.get(MatchedCountKeyEnum.FOUR_MATCHED.getKey()) * LottoPrizeEnum.FOUR_MATCHED.getAmount()
                + (long)matchedCount.get(MatchedCountKeyEnum.FIVE_MATCHED.getKey()) * LottoPrizeEnum.FIVE_MATCHED.getAmount()
                + (long)matchedCount.get(MatchedCountKeyEnum.FIVE_WITH_BONUS_MATCHED.getKey()) * LottoPrizeEnum.FIVE_WITH_BONUS_MATCHED.getAmount()
                + (long)matchedCount.get(MatchedCountKeyEnum.SIX_MATCHED.getKey()) * LottoPrizeEnum.SIX_MATCHED.getAmount();

        double profit = (revenue / (double)purchaseCost) * 100;
        BigDecimal profitRate = new BigDecimal(profit).setScale(1, RoundingMode.HALF_UP);

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(profitRate);
    }
}
