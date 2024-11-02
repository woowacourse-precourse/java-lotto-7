package lotto;

import java.util.List;

public class OutputView {
    public static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for(Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(int[] resultCount, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5,000원) - %d개\n", resultCount[LottoRank.FIFTH.ordinal()]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", resultCount[LottoRank.FOURTH.ordinal()]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", resultCount[LottoRank.THIRD.ordinal()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", resultCount[LottoRank.SECOND.ordinal()]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", resultCount[LottoRank.FIRST.ordinal()]);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
