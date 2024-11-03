package lotto.statistics;

import constants.Constants;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningStatistics {

    private static final String BONUS_STATISTICS_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String BASIC_STATISTICS_FORMAT = "%d개 일치 (%s원) - %d개";

    public static String winningStatus() {
        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank != WinningRank.NONE)
                .map(WinningStatistics::selectStatus)
                .collect(Collectors.joining("\n"));
    }

    private static String selectStatus(WinningRank rank) {
        String reward = formattingReward(rank);

        if (isSecond(rank)) {
            return secondStatistics(rank, reward);
        }
        return statistics(rank, reward);
    }

    private static String formattingReward(WinningRank rank) {
        return Constants.AMOUNT_NOTATION.format(rank.getReward());
    }

    private static boolean isSecond(WinningRank rank) {
        return rank == WinningRank.SECOND;
    }

    private static String secondStatistics(WinningRank rank, String reward) {
        return String.format(BONUS_STATISTICS_FORMAT, rank.getRequiredMatch(), reward, rank.getSuccessMatch());
    }

    private static String statistics(WinningRank rank, String reward) {
        return String.format(BASIC_STATISTICS_FORMAT, rank.getRequiredMatch(), reward, rank.getSuccessMatch());
    }
}
