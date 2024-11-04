package lotto.view;

import lotto.Application;
import lotto.Prize;

public class OutputView {
    private static final int BONUS_RANK = 2;

    public static void printCntLotto(int cntLotto) {
        System.out.println(cntLotto + "개를 구매했습니다.");
    }

    public static void printResultPrize() {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        for (int rank = 5; rank >= 1; rank--) {
            Prize prize = Prize.checkByRank(rank);
            if (rank == BONUS_RANK) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", prize.getMatchNumbers(), prize.getMoney(),
                        Application.perRankCount[rank]);
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개\n", prize.getMatchNumbers(), prize.getMoney(),
                    Application.perRankCount[rank]);
        }
    }

    public static void printRevenue(double total, int buy) {
        double totalRevenue = total / buy * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", totalRevenue);
    }
}
