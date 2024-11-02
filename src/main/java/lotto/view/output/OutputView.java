package lotto.view.output;

import lotto.common.ViewConstants;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.Rank;
import lotto.domain.winning.WinningResult;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final DecimalFormat formatter = new DecimalFormat("#,###");
    private static final DecimalFormat earningsFormatter = new DecimalFormat("#.##");

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

        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);

        for (Rank rank : ranks) {
            if (rank != Rank.NO_WIN) {
                String formattedPrize = formatter.format(rank.getPrize());
                System.out.printf(ViewConstants.WINNING_STATISTICS_FORMAT, rank.getMessage(), formattedPrize, rankCounts.getOrDefault(rank, 0));
            }
        }
    }

    public static void printEarningsRate(double earningsRate) {
        String formattedEarningsRate = earningsFormatter.format(earningsRate);
        System.out.printf("총 수익률은 %s%%입니다.\n", formattedEarningsRate);
    }
}