package lotto.view;

import lotto.model.Lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String STRING_FOR_PRINT_RESULT = "당첨 통계\n---\n";

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

    public static void printUserLottoStatistics(LinkedHashMap<String, Integer> userLottoStatistics) {
        System.out.print(STRING_FOR_PRINT_RESULT);

        for (Map.Entry<String, Integer> entry : userLottoStatistics.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + "개");
        }
    }

    public static void printUserRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }
}
