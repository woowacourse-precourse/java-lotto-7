package lotto.view;

import lotto.model.Lotto;
import lotto.model.Prize;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLotto(int purchaseCount, List<Lotto> lottos) {
        System.out.println();
        System.out.println(purchaseCount + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println();
    }

    public void printWinningDetail(Map<Prize, Integer> prizeIntegerMap) {
        System.out.println("당첨 통계\n---");
        for (Prize prize : Prize.values()) {
            if (prize != Prize.NO_MATCH) {
                System.out.println(prize.getDescription() + prizeIntegerMap.get(prize) + "개");
            }
        }
    }

    public void printRate(double rate) {
        rate = rate * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rate);
    }
}
