package lotto.global.io;

import java.util.List;
import lotto.lottery.domain.Lotto;

public abstract class OutputView {

    public static void printEmpty() {
        System.out.println();
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf("%s개를 구매했습니다.\n", lottos.size());
        lottos.forEach(l -> System.out.println(l.getNumbers()));
    }

    public static void printWinningHeader() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printWinningStatistics(String matchResults) {
        System.out.print(matchResults);
    }

    public static void printReturnRate(String returnRate) {
        System.out.printf("총 수익률은 %s입니다.", returnRate);
    }

}
