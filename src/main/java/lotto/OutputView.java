package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printResults(Map<Rank, Integer> result, int purchaseAmount, int totalPrize, double profitRate) {
        System.out.println("당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank.getMessage().isEmpty()) continue;
            int count = result.getOrDefault(rank, 0);
            System.out.printf("%s - %d개%n", rank.getMessage(), count);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
