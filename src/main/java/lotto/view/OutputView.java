package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class OutputView {

    public static void printLottoCountAndNumbers(int count, List<Lotto> lottos){
        System.out.println(count + "개를 구매했습니다.");
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(LottoResult lottoResult){
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.printf("%d개 일치%s (%s원) - %d개%n",
                        rank.getMatchCount(),
                        rank.getMatchBonus() ? ", 보너스 볼 일치" : "",
                        String.format("%,d", rank.getPrize()),
                        lottoResult.getCount(rank));
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", lottoResult.calculateYield());
    }
}
