package lotto.view;

import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.Lottos;

public class OutputView {
    public void printPurchasedLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.getSize());
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printResult(Map<LottoRanking, Integer> result, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Map.Entry<LottoRanking, Integer> entry : result.entrySet()) {
            printEachResult(entry);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }

    private void printEachResult(Entry<LottoRanking, Integer> entry) {
        if (entry.getKey() == LottoRanking.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 ", entry.getKey().getMatchCount());
            System.out.printf("(%,d원) - ", entry.getKey().getReward());
            System.out.printf("%d개%n", entry.getValue());
        }
        if (entry.getKey() == LottoRanking.NONE) {
            return;
        }
        if (entry.getKey() != LottoRanking.SECOND) {
            System.out.printf("%d개 일치 ", entry.getKey().getMatchCount());
            System.out.printf("(%,d원) - ", entry.getKey().getReward());
            System.out.printf("%d개%n", entry.getValue());
        }
    }
}
