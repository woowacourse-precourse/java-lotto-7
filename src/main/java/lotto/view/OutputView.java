package lotto.view;

import lotto.constants.Messages;
import lotto.model.LottoResult;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.Rank;

import java.util.List;

public class OutputView {
    public static void printPurchaseAmount(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.getMoney() / PurchaseAmount.LOTTE_PRICE;
        System.out.printf(Messages.PURCHASED_COUNT + "%n", lottoCount);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println(Messages.WINNING_STATISTICS_HEADER);
        System.out.println(Messages.WINNING_STATISTICS_DIVIDER);
        System.out.printf(Messages.MATCH_THREE + "%n", lottoResult.getCount(Rank.FIFTH));
        System.out.printf(Messages.MATCH_FOUR + "%n", lottoResult.getCount(Rank.FOURTH));
        System.out.printf(Messages.MATCH_FIVE + "%n", lottoResult.getCount(Rank.THIRD));
        System.out.printf(Messages.MATCH_FIVE_BONUS + "%n", lottoResult.getCount(Rank.SECOND));
        System.out.printf(Messages.MATCH_SIX + "%n", lottoResult.getCount(Rank.FIRST));
        System.out.printf(Messages.YIELD_RESULT, lottoResult.calculateYield());
    }
}
