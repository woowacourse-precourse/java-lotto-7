package lotto;

import java.util.List;

public class OutputView {

    public void printLottoNumbers(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printStatistics(LottoStatistics lottoStatistics) {
        lottoStatistics.printStatistics();
    }

    public void printRevenue(int totalRevenue, int money) {
        double revenueRate = (double) totalRevenue / money * 100;
        System.out.printf("총 수익률은 %.2f%%입니다.%n", revenueRate);
    }
}
