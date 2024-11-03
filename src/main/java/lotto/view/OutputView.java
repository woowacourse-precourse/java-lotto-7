package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.Ranking;

public class OutputView {
    
    private OutputView() {
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
    
    public static void printRankCounts(Map<Ranking, Integer> rankCounts) {
        System.out.println("당첨 통계\n---");
        for (Ranking ranking : Ranking.values()) {
            if (ranking == Ranking.LOSE) continue;
            int count = rankCounts.getOrDefault(ranking, 0);
            if (ranking == Ranking.SECOND_PLACE) {
                System.out.println(ranking.numberOfHits + "개 일치, 보너스 볼 일치 (" + String.format("%,d", ranking.award) + "원) - " + count + "개");
            } else {
                System.out.println(ranking.numberOfHits + "개 일치 (" + String.format("%,d", ranking.award) + "원) - " + count + "개");
            }
        }
    }
}
