package lotto.outputview;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;

public class OutputView {

    public void displayLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayResults(Map<Rank, Integer> resultMap) {
        System.out.println("당첨 통계");
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getPrize() + " - " + resultMap.get(rank) + "개");
        }
    }

    public void displayEarningsRate(double earningsRate) {
        System.out.println("총 수익률은 " + earningsRate + "%입니다.");
    }
}
