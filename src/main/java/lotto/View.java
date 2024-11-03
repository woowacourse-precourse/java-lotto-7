package lotto;

import java.util.Arrays;
import java.util.Map;

public class View {
    public void count(Integer count) {
        System.out.println(count+"개를 구매했습니다.");
    }

    public void lottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            String string = Arrays.toString(lotto.getNumbers().toArray());
            System.out.println(string);
        }
    }

    public void revenue(double revenue) {
        System.out.println("총 수익률은 " + revenue+"%입니다.");
    }

    public void total(Map<Rank, Integer> rankCounts) {
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
