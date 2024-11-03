package lotto.view;

import java.util.List;

public class OutputView {

    public void printBuyingLottos(List<String> lottos) {
        System.out.printf("%s개를 구매했습니다.%n", lottos.size());
        lottos.forEach(System.out::println);
    }

    public void printWinningCount(List<String> winningCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        winningCount.forEach(System.out::println);
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }
}
