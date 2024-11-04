package lotto.service.winning;

import static lotto.config.WinningMessage.HEADER;

import java.util.Map;
import lotto.domain.ProfitRate;
import lotto.service.profit.ProfitRateCalculator;
import lotto.service.profit.ProfitRateFormatter;
import lotto.utils.PrizeType;

public class WinningStatisticsFormatter {

    public static String formatStatistics(Map<PrizeType, Integer> statistics, int totalPurchaseAmount) {
        StringBuilder sb = new StringBuilder();

        appendHeader(sb);
        appendWinningEntries(sb, statistics);
        appendProfitRate(sb, statistics, totalPurchaseAmount);

        return sb.toString();
    }

    private static void appendHeader(StringBuilder sb) {
        sb.append(HEADER.getMessage()).append("\n");
    }

    private static void appendWinningEntries(StringBuilder sb, Map<PrizeType, Integer> statistics) {
        for (PrizeType prizeType : PrizeType.values()) {
            int count = statistics.getOrDefault(prizeType, 0);
            String formattedWinning = WinningEntryFormatter.formatWinnings(prizeType.getCode(), count);
            sb.append(formattedWinning).append("\n");
        }
    }

    private static void appendProfitRate(StringBuilder sb, Map<PrizeType, Integer> statistics, int totalPurchaseAmount) {
        ProfitRate profitRate = ProfitRateCalculator.calculateProfitRate(statistics, totalPurchaseAmount);
        sb.append(ProfitRateFormatter.formatAsMessage(profitRate.profitRate()));
    }
}