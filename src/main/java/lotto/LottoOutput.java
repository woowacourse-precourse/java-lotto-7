package lotto;

import java.util.List;

public class LottoOutput {
    public void printLottos(int count, List<Lotto> lottos) {
        System.out.println(count + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }

    public void printWinningStatistics(WinningResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        result.printPrizeResults();
    }

    public void printReturnRate(double returnRate) {
        System.out.printf("\n총 수익률은 %.1f%%입니다.\n", returnRate);
    }
}

