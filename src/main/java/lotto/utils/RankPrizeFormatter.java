package lotto.utils;

import lotto.domain.Rank;

import java.text.NumberFormat;
import java.util.Locale;

public class RankPrizeFormatter {

    private RankPrizeFormatter() {
    }

    public static String formatRankStatistics(Rank rank, int count) {
        return formatMatchCount(rank) +
                " (" + formatPrize(rank.getPrize().getPrize()) + "원) - " +
                count + "개";
    }

    private static String formatMatchCount(Rank rank) {
        StringBuilder result = new StringBuilder();
        result.append(rank.getMatchCount()).append("개 일치");

        if (rank.hasBonus()) {
            result.append(", 보너스 볼 일치");
        }
        return result.toString();
    }

    private static String formatPrize(int prize) {
        return NumberFormat.getNumberInstance(Locale.US).format(prize);
    }
}
