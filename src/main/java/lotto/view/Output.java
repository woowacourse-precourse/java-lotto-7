package lotto.view;

import static lotto.Rank.FIFTH;
import static lotto.Rank.FIRST;
import static lotto.Rank.FOURTH;
import static lotto.Rank.SECOND;
import static lotto.Rank.THIRD;

import java.util.List;
import lotto.Lotto;
import lotto.Rank;
import lotto.WinningRecord;

public class Output {
    private static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_NUMBER_PREFIX = "[";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String LOTTO_NUMBER_SUFFIX = "]";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";
    private static final String RANK_STATISTIC_FORMAT = "%d개 일치 (%,d원) - %d개\n";
    private static final String FIFTH_STATISTIC_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String RETURN_RATE_FORMAT = "총 수익률은 %,.1f%%입니다.";
    private static final List<Rank> winningRanks = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);

    public static void printPurchaseMessage(final int purchasedLottoesCount) {
        System.out.println(purchasedLottoesCount + LOTTO_PURCHASE_MESSAGE);
    }

    public static void printLotto(final Lotto lotto) {
        String lottoNumbers = lotto.readNumberAscending(LOTTO_NUMBER_DELIMITER);
        System.out.println(LOTTO_NUMBER_PREFIX + lottoNumbers + LOTTO_NUMBER_SUFFIX);
    }

    public static void printWinningStatistics(final WinningRecord winningRecord) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        for (Rank rank : winningRanks) {
            int winningNumberMatchCount = rank.getWinningNumberMatchCount();
            int winningAmount = rank.getWinningAmount();
            int rankCount = winningRecord.get(rank);
            String rankStatisticFormat = getRankStatisticFormat(rank);
            printRankStatistic(rankStatisticFormat, winningNumberMatchCount, winningAmount, rankCount);
        }
    }

    private static String getRankStatisticFormat(final Rank rank) {
        if (rank == SECOND) {
            return FIFTH_STATISTIC_FORMAT;
        }
        return RANK_STATISTIC_FORMAT;
    }

    private static void printRankStatistic(final String rankStatisticFormat, final int winningNumberMatchCount,
                                           final int winningAmount, final int rankCount) {
        System.out.printf(rankStatisticFormat, winningNumberMatchCount, winningAmount, rankCount);
    }

    public static void printReturnRate(final double returnRate) {
        System.out.printf(RETURN_RATE_FORMAT, returnRate);
    }
}
