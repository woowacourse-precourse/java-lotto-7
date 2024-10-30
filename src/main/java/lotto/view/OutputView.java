package lotto.view;

import lotto.model.Lotto;
import lotto.model.PurchaseAmount;

import java.util.List;

public class OutputView {
    public static void printPurchaseAmount(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.getMoney() / PurchaseAmount.LOTTE_PRICE;
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
    public static void printResultStatistics(int[] matchCounts, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("%d개 일치 (%s) - %d개\n", 3, "5,000원", matchCounts[0]);
        System.out.printf("%d개 일치 (%s) - %d개\n", 4, "50,000원", matchCounts[1]);
        System.out.printf("%d개 일치 (%s) - %d개\n", 5, "1,500,000원", matchCounts[2]);
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s) - %d개\n", 5, "30,000,000원", matchCounts[3]);
        System.out.printf("%d개 일치 (%s) - %d개\n", 6, "2,000,000,000원", matchCounts[4]);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
