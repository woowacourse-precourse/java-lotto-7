package lotto;

import java.util.List;

public class LottoOutput {
    public void displayPurchaseInfo(int count, List<Lotto> lottos) {
        System.out.println(count + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void displayResults(int[] matchCounts, double profitRate) {
        System.out.println("당첨 통계\n---");
        System.out.println(matchCounts.length+"개를 구매했습니다\n.");
        System.out.printf("3개 일치 (5,000원) - %d개\n", matchCounts[4]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", matchCounts[3]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", matchCounts[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", matchCounts[1]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", matchCounts[0]);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    public void displayErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
