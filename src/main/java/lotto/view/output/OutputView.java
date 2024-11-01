package lotto.view.output;

import lotto.common.ViewConstants;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.Rank;
import lotto.domain.winning.WinningResult;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf(ViewConstants.PURCHASED_LOTTO_COUNT, lottos.size());
        System.out.println();
        for (Lotto lotto : lottos) {
            System.out.printf(ViewConstants.LOTTO_NUMBERS, lotto.getNumbers());
            System.out.println();
        }
    }

    public static void printWinningStatistics(WinningResult result) {
        System.out.println(ViewConstants.WINNING_STATISTICS);
        System.out.println(ViewConstants.DIVIDER);

        Map<Rank, Integer> rankCounts = result.getRankCounts();
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NO_WIN) {
                System.out.printf("%s - %d개\n", rank.getMessage(), rankCounts.getOrDefault(rank, 0));
            }
        }
    }

    public static void printEarningsRate(double earningsRate) {
        System.out.printf(ViewConstants.EARNINGS_RATE, earningsRate);
        System.out.println();
    }
}
