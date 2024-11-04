package lotto.view;

import java.util.List;
import lotto.model.LottoRank;
import lotto.model.LottoRanks;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;

public class OutputView {
    private static final String PURCHASE_LOTTOS_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String RANK_MESSAGE = "%d개 일치 (%,d원) - %d개\n";
    private static final String RANK_SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String RETURN_RATE_MESSAGE = "총 수익률은 %,.1f%%입니다.\n";

    public void printPurchaseLottos(Lottos lottos) {
        int buyCount = lottos.getCount();

        System.out.printf(PURCHASE_LOTTOS_MESSAGE, buyCount);
        System.out.println(lottos);
        printEmptyLine();
    }

    public void printLottoResult(LottoRanks lottoRanks, PurchaseAmount purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<LottoRank> printList = List.of(
                LottoRank.FIFTH,
                LottoRank.FOURTH,
                LottoRank.THIRD,
                LottoRank.SECOND,
                LottoRank.FIRST
        );
        for (LottoRank lottoRank : printList) {
            printRank(lottoRanks, lottoRank);
        }
        printReturnRate(lottoRanks, purchaseAmount);
    }

    private void printReturnRate(LottoRanks lottoRanks, PurchaseAmount purchaseAmount) {
        double returnRate = lottoRanks.getReturnRate(purchaseAmount) * 100.0;

        System.out.printf(RETURN_RATE_MESSAGE, returnRate);
    }

    private void printRank(LottoRanks lottoRanks, LottoRank lottoRank) {
        int matchCount = lottoRank.getMatchCount();
        int rankCount = lottoRanks.getRankCount(lottoRank);
        long prize = lottoRank.getPrize();

        if (lottoRank == LottoRank.SECOND) {
            System.out.printf(RANK_SECOND_MESSAGE, matchCount, prize, rankCount);
            return;
        }

        System.out.printf(RANK_MESSAGE, matchCount, prize, rankCount);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
