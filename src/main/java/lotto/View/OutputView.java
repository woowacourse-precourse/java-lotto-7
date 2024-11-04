package lotto.View;

import java.sql.SQLOutput;
import java.util.Map;
import lotto.Model.Ranking;
import lotto.constants.Constants;

public class OutputView {


    public static void printWinningStatistics() {
        System.out.println(Constants.WINNING_STATISTICS);
    }

    //각 Ranking 별 일치개수를 반환 로직
    public static void printResult(Map<Ranking, Integer> rankingCount) {
        rankingCount.forEach((rank, count) -> {
            if (rank == Ranking.MISS) {
                return;
            }
            System.out.println(rank.getMessage() + count + "개");
        });

    }

    //수익률 반환 로직
    public static void printRevenueRate(double revenue) {
        System.out.println("총 수익률은 " + String.format("%.1f", revenue * 100) + "%입니다.");
    }


}
