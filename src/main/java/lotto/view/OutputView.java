package lotto.view;

import lotto.domain.Lotto;
import lotto.global.LottoPrize;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printResult(List<LottoPrize> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(LottoPrize.values())
                .filter(prize -> prize != LottoPrize.NONE)
                .forEach(prize -> {
                    long count = results.stream().filter(prize::equals).count();
                    System.out.println(prize.getMatchDescription() + " (" + prize.getPrizeMoney() + "원) - " + count + "개");
                });
    }

    public static void printProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profit * 100);
    }
}
