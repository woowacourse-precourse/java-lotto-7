package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Winning;

public class OutputView {
    public static void printLottosNum(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            String numbers = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + numbers + "]");
        }
    }

    public static void printResult(Map<Winning, Integer> results) {
        System.out.println("당첨 통계\n---");

        for (Winning winning : Winning.values()) {
            int count = results.getOrDefault(winning, 0);
            System.out.printf("%d개 일치 (%d원) - %d개\n",
                    winning.getMatchCount(),
                    winning.getPrize(),
                    count);
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
