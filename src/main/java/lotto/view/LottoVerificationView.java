package lotto.view;

import lotto.model.Rank;

import java.util.Map;

public class LottoVerificationView {
    public static void printResult(Map<Rank, Integer> rankCounts, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) {
                continue;
            }
            int count = rankCounts.getOrDefault(rank, 0);
            System.out.println(rank.getMatchNumberCount() + "개 일치"
                    + (rank.isMatchBonusNumber() ? ", 보너스 볼 일치" : "")
                    + " (" + rank.getPrize() + "원) - "
                    + count + "개");
        }
        System.out.printf("총 수익률은 %.2f%%입니다.%n", rateOfReturn);
    }

}
