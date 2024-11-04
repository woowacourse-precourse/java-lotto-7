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
            String output = String.format("%d개 일치 (%s) - %d개\n",
                    winning.getMatchCount(),
                    String.format("%,d원", winning.getPrize()),
                    count);
            if (winning == Winning.FIVE_MATCH_WITH_BONUS) {
                output = String.format("%d개 일치, 보너스 볼 일치 (%s) - %d개\n",
                        winning.getMatchCount(),
                        String.format("%,d원", winning.getPrize()),
                        count);
            }
            System.out.print(output);
        }
    }



    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
