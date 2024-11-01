package lotto.view;

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
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) {
                continue; // 꽝인 경우는 출력 생략
            }
            int count = resultMap.getOrDefault(rank, 0);
            System.out.println(rank.getDescription() + " - " + count + "개");
        }
    }

    public void displayEarningsRate(double earningsRate) {
        System.out.println("총 수익률은 " + earningsRate + "%입니다.");
    }

    public void displayError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
