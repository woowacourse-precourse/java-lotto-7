package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Result;

import java.util.List;
import java.util.Map;

public class OutputView {

    // 발행한 로또의 수량과 각 로또의 번호를 출력
    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResults(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> rankCount = result.getRankCount();
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.printf("%d개 일치%s (%s원) - %d개%n",
                        rank.getMatchCount(),
                        rank.requiresBonus() ? ", 보너스 볼 일치" : "",
                        String.format("%,d", rank.getReward()),  // 쉼표를 포함한 금액 형식
                        rankCount.get(rank));
            }
        }

        double yield = result.calculateYield();
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}