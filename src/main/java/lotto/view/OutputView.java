package lotto.view;
public class OutputView{
private static void printResultList(java.util.Map<lotto.model.Rank,java.lang.Integer> resultMap) {
        java.lang.System.out.println("당첨 통계\n---");
        for (lotto.model.Rank rank : lotto.model.Rank.values()) {
            if (rank != lotto.model.Rank.NONE) {
                int count = resultMap.getOrDefault(rank, 0);
                java.lang.String bonusMessage = "";
                if (rank.isRequiresBonus()) {
                    bonusMessage = ", 보너스 볼 일치";
                }
                java.lang.System.out.printf("%d개 일치%s (%,d원) - %d개\n", rank.getMatchCount(), bonusMessage, rank.getPrize(),
                        count);
            }
        }
    }}