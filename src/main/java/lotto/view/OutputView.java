package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.WinningStatistics;
import lotto.utils.Message;

import java.util.List;

public class OutputView {
    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf(Message.PURCHASED_COUNT_MESSAGE + "\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printWinningStatistics(WinningStatistics statistics, int purchaseAmount) {
        System.out.println(Message.WINNING_STATISTICS_HEADER);
        for (Rank rank : Rank.getWinningRanks()) {
            int count = statistics.getCount(rank);
            System.out.println(rank.getMatchMessage() + " - " + count + "개");
        }
        double profitRate = statistics.calculateProfitRate(purchaseAmount);
        System.out.printf(Message.TOTAL_PROFIT_MESSAGE + "\n", profitRate);
    }
}
