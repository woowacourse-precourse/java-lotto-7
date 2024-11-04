package lotto;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printPurchaseInfo(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(Lotto::printNumbers);
    }

    public static void printResults(LottoResult result, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            printWithoutNone(result, rank);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.calculateProfitRate(purchaseAmount));
    }

    private static void printWithoutNone(LottoResult result, Rank rank) {
        if (rank != Rank.NONE) {
            System.out.printf("%s - %d개\n", rank.getDescription(), result.getCount(rank));
        }
    }
}
