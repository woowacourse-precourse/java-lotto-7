package lotto.view;

import static lotto.Rank.FIFTH;
import static lotto.Rank.FIRST;
import static lotto.Rank.FOURTH;
import static lotto.Rank.SECOND;
import static lotto.Rank.THIRD;
import static lotto.view.OutputMessage.LOTTO_NUMBER;
import static lotto.view.OutputMessage.LOTTO_PURCHASE;
import static lotto.view.OutputMessage.RANK_STATISTIC;
import static lotto.view.OutputMessage.RETURN_RATE;
import static lotto.view.OutputMessage.SECOND_STATISTIC;
import static lotto.view.OutputMessage.WINNING_STATISTICS;

import java.util.List;
import lotto.Lotto;
import lotto.Rank;
import lotto.WinningRecord;

public class Output {
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s\n\n";
    private static final List<Rank> winningRanks = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);

    public static void printPurchaseMessage(final int purchasedLottoesCount) {
        System.out.printf(LOTTO_PURCHASE.getMessage(), purchasedLottoesCount);
    }

    public static void printLotto(final Lotto lotto) {
        String lottoNumbers = lotto.readNumberAscending(LOTTO_NUMBER_DELIMITER);
        System.out.printf(LOTTO_NUMBER.getMessage(), lottoNumbers);
    }

    public static void printWinningStatistics(final WinningRecord winningRecord) {
        System.out.println(WINNING_STATISTICS.getMessage());
        for (Rank rank : winningRanks) {
            int winningNumberMatchCount = rank.getWinningNumberMatchCount();
            int winningAmount = rank.getWinningAmount();
            int rankCount = winningRecord.get(rank);
            printRankStatistic(getRankStatisticFormat(rank), winningNumberMatchCount, winningAmount, rankCount);
        }
    }

    private static String getRankStatisticFormat(final Rank rank) {
        if (rank == SECOND) {
            return SECOND_STATISTIC.getMessage();
        }
        return RANK_STATISTIC.getMessage();
    }

    private static void printRankStatistic(final String rankStatisticFormat, final int winningNumberMatchCount,
                                           final int winningAmount, final int rankCount) {
        System.out.printf(rankStatisticFormat, winningNumberMatchCount, winningAmount, rankCount);
    }

    public static void printReturnRate(final double returnRate) {
        System.out.printf(RETURN_RATE.getMessage(), returnRate);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.printf(ERROR_MESSAGE_FORMAT, errorMessage);
    }
}
