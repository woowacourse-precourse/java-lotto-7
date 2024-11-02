package lotto.view;

import java.util.Map;
import lotto.model.Rank;

public class OutputView {
    public static void printResultList(Map<Rank, Integer> resultMap) {
        System.out.println("당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                int count = resultMap.getOrDefault(rank, 0);
                String bonusMessage = "";
                if (rank.isRequiresBonus()) {
                    bonusMessage = ", 보너스 볼 일치";
                }
                System.out.printf("%d개 일치%s (%,d원) - %d개\n", rank.getMatchCount(), bonusMessage, rank.getPrize(),
                        count);
            }
        }
    }
    public static void printResultProfit(double totalPrize) {
        System.out.printf("총 수익률은 %.1f%%입니다.",totalPrize);
    }
}