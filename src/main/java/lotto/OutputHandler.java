package lotto;

import java.util.List;
import java.util.Map;

public class OutputHandler {

    public void printBudgetMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchasedLottoCount(int purchasedLottoCount) {
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningLottoMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요");
    }

    public void printStatistics(Map<Rank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }
            if (rank == Rank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", rank.getNumberMatch(), rank.getPrize(),
                        result.get(rank));
                System.out.println();
                continue;
            }
            System.out.printf("%d개 일치 (%,d원) - %d개", rank.getNumberMatch(), rank.getPrize(), result.get(rank));
            System.out.println();
        }
    }

    public void printRateOfReturn(float totalProfit, int budget) {
        System.out.printf("총 수익률은 %.1f%%입니다.", (totalProfit / budget) * 100);

    }
}
