package lotto;

import java.util.Map;

public class OutputView {

    private static final String RETURN_RATE_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.\n";
    private static final String RANK_STATISTICS_MESSAGE_FORMAT = "%s (%,d원) - %d개\n";

    public void printWinningStatistics(final Map<Rank, Integer> rankCounts, final double returnRate) {
        System.out.println(Message.WINNING_STATISTICS.getMessage());
        printRankStatistics(Rank.FIFTH, rankCounts);
        printRankStatistics(Rank.FOURTH, rankCounts);
        printRankStatistics(Rank.THIRD, rankCounts);
        printRankStatistics(Rank.SECOND, rankCounts);
        printRankStatistics(Rank.FIRST, rankCounts);
        System.out.printf(RETURN_RATE_MESSAGE_FORMAT, returnRate);
    }

    private void printRankStatistics(final Rank rank, final Map<Rank, Integer> rankCounts) {
        System.out.printf(RANK_STATISTICS_MESSAGE_FORMAT,
                rank.getDescription(),
                rank.getPrizeMoney(),
                rankCounts.get(rank));
    }
}
