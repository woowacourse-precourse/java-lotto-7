package lotto.system.formater.winning;

import java.util.Map;
import lotto.system.formater.profit.ProfitRateCalculator;
import lotto.system.formater.profit.ProfitRateFormatter;
import lotto.system.utils.PrizeType;

public class WinningStatisticsFormatter {

    private static final String STATISTICS_HEADER = "당첨 통계\n---";

    public static String formatStatistics(Map<PrizeType, Integer> statistics, int totalPurchaseAmount) {
        StringBuilder sb = new StringBuilder();
        sb.append(STATISTICS_HEADER).append("\n");

        for (PrizeType prizeType : PrizeType.values()) {
            int count = statistics.getOrDefault(prizeType, 0);
            String formattedWinning = WinningEntryFormatter.formatWinnings(prizeType.getCode(), count);
            sb.append(formattedWinning).append("\n");
        }
        ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator(statistics, totalPurchaseAmount);
        double profitRate = profitRateCalculator.calculator();
        sb.append(ProfitRateFormatter.formatAsMessage(profitRate));
        return sb.toString();
    }
}
