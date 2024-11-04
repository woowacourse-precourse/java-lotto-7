package lotto.presentation.view;

import java.util.Arrays;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;

public class View {
    public void printGuide(String message) {
        System.out.println(message);
    }

    public void printPurchaseCount(Integer count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            String string = Arrays.toString(lotto.getNumbers().toArray());
            System.out.println(string);
        }
    }

    public void printRevenue(double revenue) {
        System.out.println("총 수익률은 " + revenue + "%입니다.");
    }

    public void printWinningStatistics(Map<Rank, Integer> rankCounts) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rankCounts.get(Rank.FIFTH) +"개");
        System.out.println("4개 일치 (50,000원) - " + rankCounts.get(Rank.FOURTH) +"개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCounts.get(Rank.THIRD) +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCounts.get(Rank.SECOND) +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCounts.get(Rank.FIRST) +"개");
    }
}
