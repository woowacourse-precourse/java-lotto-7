package lotto.view;

import lotto.Lotto;
import lotto.domain.Prize;
import lotto.domain.Result;

import java.util.List;
import java.util.Map;

public class OutputView {
        public static void printPurchaseCount(int count) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
     public static void printWinningStatistics(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Prize, Integer> results = result.getResults();
        printPrizeResult(Prize.FIFTH, results.get(Prize.FIFTH));
        printPrizeResult(Prize.FOURTH, results.get(Prize.FOURTH));
        printPrizeResult(Prize.THIRD, results.get(Prize.THIRD));
        printPrizeResult(Prize.SECOND, results.get(Prize.SECOND));
        printPrizeResult(Prize.FIRST, results.get(Prize.FIRST));

        System.out.printf("총 수익률은 %.1f%%입니다.%n", result.calculateReturnRate());
    }

    private static void printPrizeResult(Prize prize, int count) {
        System.out.printf("%s (%,d원) - %d개%n",
            prize.getDescription(),
            prize.getPrize(),
            count);
    }
}
