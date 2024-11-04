package lotto;

import java.util.List;

public class ProfitCalculator {

    public static long calculateTotalProfit(List<MatchCountMessage> winningResults) {
        long totalProfit = 0;
        for (MatchCountMessage result : winningResults) {
            totalProfit += result.getPrize();
        }
        return totalProfit;
    }
}
