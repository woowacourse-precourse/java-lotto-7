package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    //발행된 로또의 수량과 번호를 오름차순으로 정리하여 출력
    public void printPurchasedLottos(List<Lotto> lottos){
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    // 당첨 통계와 수익률을 포함한 전체 결과 출력
    public void printResult(Map<Rank, Integer> result, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) continue;
            System.out.printf(
                "%d개 일치%s (%s원) - %d개%n",
                rank.getMatchCount(),
                rank.isMatchBonus() ? ", 보너스 볼 일치" : "",
                rank.getPrizeToString(),
                result.getOrDefault(rank, 0)
            );
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }


}
