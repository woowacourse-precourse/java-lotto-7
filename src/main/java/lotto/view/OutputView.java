package lotto.view;

import static lotto.constant.LottoOutputMessage.OUTPUT_PROFIT_RATE;
import static lotto.constant.LottoOutputMessage.OUTPUT_PURCHASE_COUNT;
import static lotto.constant.LottoOutputMessage.OUTPUT_WINNING_STATISTICS;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {

    public void printPurchaseCount(int purchaseCount) {
        System.out.println();
        System.out.println(purchaseCount + OUTPUT_PURCHASE_COUNT);
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printWinningStatistics(Map<Rank, Integer> rankCounts) {
        System.out.println();
        System.out.println(OUTPUT_WINNING_STATISTICS);

        for (Rank rank : new Rank[]{Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST}) {
            System.out.printf(rank.getMessage() + rank.getFormattedPrize() + " - " + rankCounts.get(rank) + "개%n");
        }
    }

    public void printProfitRate(String profitRate) {
        System.out.printf((OUTPUT_PROFIT_RATE) + "%n", profitRate);
    }
}
