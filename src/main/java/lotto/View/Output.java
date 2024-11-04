package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.Rank;

import java.util.Collections;
import java.util.List;

public class Output {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(List<Rank> ranks, double profitRate) {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", Collections.frequency(ranks, Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", Collections.frequency(ranks, Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", Collections.frequency(ranks, Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", Collections.frequency(ranks, Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", Collections.frequency(ranks, Rank.FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
