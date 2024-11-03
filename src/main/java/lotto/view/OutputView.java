package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static void printUserLottos(List<Lotto> lottos, int userAmount) {
        System.out.println(userAmount + "개를 구매헀습니다.");
        for (Lotto lotto : lottos) {
            String formattedLotto = lotto.getNumbers()
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + formattedLotto + "]");
        }
        System.out.println();
    }

    public static void printUserLottoStatistics(Map<String, Integer> userLottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Map.Entry<String, Integer> entry : userLottoStatistics.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + "개");
        }
    }
}
