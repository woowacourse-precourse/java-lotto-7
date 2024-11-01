package lotto;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    public void printLottoNumbers(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printStatistics(HashMap<Integer, Integer> map) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + map.getOrDefault(3, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + map.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + map.getOrDefault(5, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + map.getOrDefault(6, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + map.getOrDefault(6, 0) + "개");
    }

    public void printRevenue(HashMap<Integer, Integer> map, int money) {
        int totalRevenue = (map.getOrDefault(3, 0) * 5000) +
                (map.getOrDefault(4, 0) * 50000) +
                (map.getOrDefault(5, 0) * 1500000) +
                (map.getOrDefault(6, 0) * 2000000000);

        double revenueRate = (double) totalRevenue / money * 100;

        System.out.printf("총 수익률은 %.2f%%입니다.\n", revenueRate);
    }

}
