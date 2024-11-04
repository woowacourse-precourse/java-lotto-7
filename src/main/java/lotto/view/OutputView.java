package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class OutputView {


    public static void printLottos(List<Lotto> lottos){
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }


    public static void printResult(LottoResult result, int purchaseAmount) {
        System.out.println("당첨 통계\n---");
        Map<Rank, Integer> results = result.getResults();

        // 등수와 보너스 여부에 대한 정보를 배열로 정의
        Rank[] ranks = {Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.SECOND, Rank.FIRST};

        // 각 등수에 대한 형식 및 보너스 여부를 출력
        for (Rank rank : ranks) {
            String bonus = (rank == Rank.SECOND) ? ", 보너스 볼 일치" : ""; // 2등의 경우 보너스 추가
            System.out.printf("%d개 일치%s (%,d원) - %d개\n",
                    rank.getMatchingCount(),
                    bonus,
                    rank.getPrize(),
                    results.getOrDefault(rank, 0));
        }

        // 전체 티켓 수를 계산하여 수익률 계산 메서드에 전달
        double earningsRate = result.calculateEarningsRate(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningsRate); // 소수점 첫째 자리까지 반올림
    }



}
