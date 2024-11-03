package lotto.utils.formatter;

import lotto.domain.core.Rank;

import java.text.NumberFormat;
import java.util.Locale;

public class RankPrizeFormatter {

    private RankPrizeFormatter() {
    }

    private static final String MATCH_COUNT_SUFFIX = "개 일치";
    private static final String BONUS_MATCH_SUFFIX = ", 보너스 볼 일치";
    private static final String PRIZE_FORMAT = "원";
    private static final String OPEN_PARENTHESIS = " (";
    private static final String CLOSE_PARENTHESIS = ")";
    private static final String DASH = " - ";
    private static final String COUNT_SUFFIX = "개";

    public static String formatRankStatistics(Rank rank, int count) {
        return formatMatchCount(rank) +
                OPEN_PARENTHESIS + formatPrize(rank.getPrize()) + PRIZE_FORMAT + CLOSE_PARENTHESIS + DASH + count + COUNT_SUFFIX;
    }

    private static String formatMatchCount(Rank rank) {
        StringBuilder result = new StringBuilder();
        result.append(rank.getMatchCount()).append(MATCH_COUNT_SUFFIX);

        if (rank.hasBonus()) {
            result.append(BONUS_MATCH_SUFFIX);
        }
        return result.toString();
    }

    private static String formatPrize(int prize) {
        return NumberFormat.getNumberInstance(Locale.US).format(prize);
    }
}
