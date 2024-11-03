package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Result;

import java.util.List;

public class OutputView {
    public static void printPurchase(List<Lotto> lottos){
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(Result result) {
        System.out.println("\n당첨 통계\n---");

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) continue; // NONE 등수는 출력하지 않음
            printRank(rank, result);
        }
    }

    private static void printRank(Rank rank, Result result) {
        if (rank == Rank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n",
                    rank.getMatchCount(),
                    rank.getPrize(),
                    result.getMatchCount().getOrDefault(rank, 0));

            return;
        }
        System.out.printf("%d개 일치 (%,d원) - %d개%n",
                rank.getMatchCount(),
                rank.getPrize(),
                result.getMatchCount().getOrDefault(rank, 0));
    }

}
