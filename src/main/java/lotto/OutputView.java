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

    public void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println("\n당첨 통계");
        lottoStatistics.printStatistics();
    }

    public void printRevenue(int totalRevenue, int money) {
        double revenueRate = (double) totalRevenue / money * 100;
        String formattedRate = String.format("%.2f", revenueRate).replaceAll("0*$", "").replaceAll("\\.$", "");

        System.out.printf("총 수익률은 %s%%입니다.\n", formattedRate);
    }

}
