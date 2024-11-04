package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {


    public static void printLottos(List<Lotto> lottos){
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(LottoResult result){
        System.out.println("당첨 통계\n---");
        Map<Rank,Integer> results = result.getResults();

        for(Rank rank : Rank.values()){
            if(rank !=Rank.NONE){
                System.out.printf("%d개 일치 (%d원) - %d개\n", rank.ordinal(), rank.getPrize(), results.getOrDefault(rank, 0));
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.calculateEarningsRate(results.values().stream().mapToInt(i -> i).sum()));
    }
}
