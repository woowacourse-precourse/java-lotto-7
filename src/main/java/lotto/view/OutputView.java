package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {

    public void printPurchasedLottoCount(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public void printPurchaserLottos(List<Lotto> purchasedLottos) {
        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto.getNumbers());
        }
        System.out.println();
    }

    public void printWinningStatistics(Map<Rank, Integer> rankResult, String profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getMatchDescription() + " - " + rankResult.get(rank) + "개");
        }
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }
}
