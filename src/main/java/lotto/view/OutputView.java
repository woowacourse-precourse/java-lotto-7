package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printResult(LottoResult result, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Map.Entry<Rank, Integer> entry : result.getRankCounts().entrySet()) {
            if (entry.getKey() != Rank.NONE) {
                System.out.printf("%s - %d개%n", entry.getKey().getMessage(), entry.getValue());
            }
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", result.calculateYield(purchaseAmount));
    }
}
