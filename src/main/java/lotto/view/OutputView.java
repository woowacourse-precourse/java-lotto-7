package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();
    }

    public void printStatistics(Map<Rank, Integer> results, double yield) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        Rank[] ranks = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
        for (Rank rank : ranks) {
            System.out.println(rank.getFormattedResult(results.getOrDefault(rank, 0)));
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    public void printError(String message) {
        System.out.println();
        System.out.println(message);
    }
}
