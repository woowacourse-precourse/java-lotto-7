package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ProfitCalculator {

    public static long calculateTotalProfit(List<MatchCountMessage> winningResults) {
        long totalProfit = 0;
        for (MatchCountMessage result : winningResults) {
            if (result != null) {
                totalProfit += result.getPrize();
            }
        }
        return totalProfit;
    }

    private static double roundToTwoDecimalPlaces(double value) {
        BigDecimal roundedValue = BigDecimal.valueOf(value)
                .setScale(2, RoundingMode.HALF_UP);
        return roundedValue.doubleValue();
    }

    public static double calculateProfitRate(long totalProfit, long purchaseAmount) {
        double profitRate = ((double) totalProfit / purchaseAmount) * 100;
        return roundToTwoDecimalPlaces(profitRate);
    }
}
