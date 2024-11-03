package lotto;

import java.util.List;

public class OutputView {
    public static void displayLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getNumbers());
        }
    }

    public static void displayResults(int[] matchCounts, int totalPrice) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.printf("3개 일치 (5,000원) - %d개\n", matchCounts[2]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", matchCounts[3]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", matchCounts[4]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", matchCounts[5]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", matchCounts[6]);

        int totalEarnings = (matchCounts[6] * 2000000000) + (matchCounts[5] * 30000000)
                + (matchCounts[4] * 1500000) + (matchCounts[3] * 50000) + (matchCounts[2] * 5000);

        double yield = (double) totalEarnings / totalPrice * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}
