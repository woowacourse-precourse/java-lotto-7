package lotto.view;

import static lotto.constant.Constants.DEFAULT_STATISTIC_COUNT;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import lotto.constant.StatisticsOutputMessage;
import lotto.model.Rank;

public class StatisticOutputView {
    private static final NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);

    public static void printLottoResults(Map<Rank, Integer> results) {
        System.out.println(StatisticsOutputMessage.START_COMMENT.getMessage());
        System.out.println(StatisticsOutputMessage.START_LINE.getMessage());

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }
            int count = results.getOrDefault(rank, DEFAULT_STATISTIC_COUNT);
            printRankResult(rank, count);
        }
    }

    private static void printRankResult(Rank rank, int count) {
        String formattedPrize = formatPrize(rank.getPrizeMoney());
        if (rank == Rank.SECOND) {
            printResultWithBonus(rank, formattedPrize, count);
        }
        if (rank != Rank.SECOND) {
            printStandardResult(rank, formattedPrize, count);
        }
    }

    private static String formatPrize(int prizeMoney) {
        return numberFormat.format(prizeMoney);
    }

    private static void printStandardResult(Rank rank, String formattedPrize, int count) {
        System.out.printf(StatisticsOutputMessage.CONTENT_OF_LOTTO_RESULT.getMessage(),
                rank.getMatchCount(), formattedPrize, count);
    }

    private static void printResultWithBonus(Rank rank, String formattedPrize, int count) {
        System.out.printf(StatisticsOutputMessage.CONTENT_OF_RESULT_FOR_BONUS_NUMBER.getMessage(),
                rank.getMatchCount(), formattedPrize, count);
    }


    public static void printProfitRate(double profitRate) {
        System.out.printf(StatisticsOutputMessage.PROFIT_RATE.getMessage(), profitRate);
    }
}