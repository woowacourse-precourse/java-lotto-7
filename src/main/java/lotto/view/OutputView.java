package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Message;
import lotto.PrizeRank;

public class OutputView {
    public void printLottos(int purchaseAmount, List<Lotto> lottos) {
        System.out.printf(("\n" + Message.PURCHASE_LOTTO.getMessage()) + "\n", purchaseAmount);
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public void printPrizeStats(Map<PrizeRank, Integer> prizeRankCounts, double rateOfReturn) {
        System.out.println("\n" + Message.PRIZE_STATS.getMessage());
        System.out.printf(Message.FIFTH_PRIZE.getMessage() + "\n", prizeRankCounts.get(PrizeRank.FIFTH));
        System.out.printf(Message.FOURTH_PRIZE.getMessage() + "\n", prizeRankCounts.get(PrizeRank.FOURTH));
        System.out.printf(Message.THIRD_PRIZE.getMessage() + "\n", prizeRankCounts.get(PrizeRank.THIRD));
        System.out.printf(Message.SECOND_PRIZE.getMessage() + "\n", prizeRankCounts.get(PrizeRank.SECOND));
        System.out.printf(Message.FIRST_PRIZE.getMessage() + "\n", prizeRankCounts.get(PrizeRank.FIRST));
        System.out.printf(Message.RATE_OF_RETURN.getMessage() + "\n", rateOfReturn);
    }
}
