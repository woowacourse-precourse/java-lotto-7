package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Prize;

public class OutputView {
    public static void printLottoBuyHistory(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = lotto.getNumbers()
                            .stream()
                            .sorted()
                            .toList();

            System.out.println(sortedNumbers);
        }
    }

    public static void printResult(Map<Prize, Integer> result, double profitRate) {
        System.out.println("당첨 통계\n---");
        for (int i = Prize.values().length - 2; i >= 0; i--) {
            Prize rank = Prize.values()[i];
            System.out.println(rank.getMessage() + " - " + result.get(rank) + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
