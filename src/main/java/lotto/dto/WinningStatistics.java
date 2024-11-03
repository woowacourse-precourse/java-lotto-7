package lotto.dto;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.model.LottoPurchaseAmount;
import lotto.model.WinningResult;
import lotto.rank.Ranking;

public class WinningStatistics {
    private static final String HEADER = "당첨 통계";
    private static final String NEW_LINE = "\n";
    private static final String DIVIDING_LINE = "---";
    private static final String WINNING_DETAILS = "%d개 일치 (%s원) - %d개";
    private static final String WINNING_DETAILS_FOR_SECOND = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String EARNINGS_RATE = "총 수익률은 %s%%입니다.";

    private final Map<Ranking, Integer> rankCounts;
    private final double earningsRate;

    public WinningStatistics(LottoPurchaseAmount lottoPurchaseAmount, WinningResult winningResult) {
        rankCounts = winningResult.getRankCounts();
        earningsRate = (double) winningResult.getTotalPrize() / lottoPurchaseAmount.purchaseAmount() * 100;
    }

    public String getWinningStatisticsMessage() {
        StringBuilder message = new StringBuilder();

        message.append(HEADER).append(NEW_LINE);
        message.append(DIVIDING_LINE).append(NEW_LINE);
        for (Ranking ranking : rankCounts.keySet()) {
            if (ranking == Ranking.NONE) {
                continue;
            }
            message.append(formatWinningDetails(ranking)).append(NEW_LINE);
        }
        message.append(formatEarningsRateMessage()).append(NEW_LINE);

        return message.toString();
    }

    private String formatWinningDetails(Ranking ranking) {
        int matchCount = ranking.getMatchCount();
        String formattedPrize = formatPrize(ranking.getPrize());
        int actualMatchCount = rankCounts.get(ranking);

        if (ranking == Ranking.SECOND) {
            return String.format(WINNING_DETAILS_FOR_SECOND, matchCount, formattedPrize, actualMatchCount);
        }

        return String.format(WINNING_DETAILS, matchCount, formattedPrize, actualMatchCount);
    }

    private static String formatPrize(long prize) {
        return new DecimalFormat("###,###").format(prize);
    }

    private String formatEarningsRateMessage() {
        return String.format(EARNINGS_RATE, formatEarningsRate(earningsRate));
    }

    private static String formatEarningsRate(double earningsRate) {
        return new DecimalFormat("#,##0.0").format(earningsRate);
    }
}
