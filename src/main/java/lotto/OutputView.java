package lotto;

import java.util.List;

public class OutputView {
    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printResult(LottoResult result, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (int i = LottoRank.values().length - 1; i >= 0; i--) {
            LottoRank rank = LottoRank.values()[i];
            if (rank != LottoRank.NONE) {
                System.out.printf("%s - %d개\n", rank.getDescription(), result.getCountForRank(rank));
            }
        }
        double returnRate = result.calculateReturnRate(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }
}