package view;

import domain.Lotto;
import global.LottoPrize;

import java.util.List;

public class OutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printResult(List<LottoPrize> results) {
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize == LottoPrize.NONE) continue;
            long count = results.stream().filter(prize::equals).count();
            System.out.println(prize.getMatchNumberCount() + "개 일치 " + "(" + prize.getPrizeMoney() + "원) - " + count + "개");
        }
    }

    public static void printProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profit * 100);
    }
}
