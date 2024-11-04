package lotto.view;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.Rank;
import lotto.model.Money;
import lotto.model.Statistics;

public class StatisticsView {

    private static final double PERCENT_MULTIPLIER = 100.0;
    private static final String STATISTICS_BEGIN_MESSAGE = "당첨 통계" + System.lineSeparator() + "---";
    private static final String STATISTIC_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String STATISTIC_FORMAT_WITH_BONUS_NUMBER = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printStatistics(Statistics statistics, Money capital) {
        System.out.println(STATISTICS_BEGIN_MESSAGE);
        for (Rank rank : getRanksToPrint()) {
            printStatistic(rank, statistics.getFrequencyOf(rank));
        }
        printProfitRate(capital, statistics.getProfit());
    }

    private List<Rank> getRanksToPrint() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private void printStatistic(Rank rank, int frequency) {
        int matchCount = rank.getMatchCount();
        Money prize = rank.getPrize();
        if (!rank.hasBonusNumber()) {
            System.out.printf(STATISTIC_FORMAT, matchCount, formatWithComma(prize), frequency);
        }
        if (rank.hasBonusNumber()) {
            System.out.printf(STATISTIC_FORMAT_WITH_BONUS_NUMBER, matchCount, formatWithComma(prize), frequency);
        }
        System.out.println();
    }

    private void printProfitRate(Money capital, Money profit) {
        double profitRate = capital.calculateProfitRateOf(profit);
        System.out.printf(PROFIT_RATE_FORMAT, convertRateToPercentage(profitRate));
    }

    private double convertRateToPercentage(double rate) {
        return rate * PERCENT_MULTIPLIER;
    }

    private String formatWithComma(Money prize) {
        return NumberFormat.getInstance()
                .format(prize.getAmount());
    }
}
