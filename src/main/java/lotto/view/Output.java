package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

public class Output {
    public void purchaseAmount(List<Lotto> issuedLotto) {
        System.out.println("\n" + issuedLotto.size() + "개를 구매했습니다.");
        for (Lotto lotto : issuedLotto) {
            System.out.println(lotto);
        }
    }

    public void result(Map<Ranking, Integer> rankingCounts, int totalSpent, int totalPrize) {
        System.out.println("\n당첨 통계\n---");
        for (Ranking rank : Ranking.values()) {
            int count = rankingCounts.get(rank);
            System.out.printf("%d개 일치%s (%d원) - %d개\n",
                    rank.getMatchCount(),
                    rank.isBonus() ? ", 보너스 볼 일치" : "",
                    rank.getPrize(),
                    count
            );
        }

        double profitRate = ((double) totalPrize / totalSpent) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
