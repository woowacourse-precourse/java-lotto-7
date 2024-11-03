package lotto.view;

import lotto.Lotto;
import lotto.Rank;
import lotto.WinningResult;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConsoleOutput {
    public void printLottoTicket(int lottoQuantity, List<Lotto> lottos) {
        System.out.println("\n" + lottoQuantity + "개를 구매했습니다.");
        lottos.forEach(
                lotto -> System.out.println(lotto.getNumbers())
        );
    }

    public void printPrizeStatistics(WinningResult result) {
        System.out.println("당첨통계");
        System.out.println("---");
        Map<Rank, Integer> counts = result.getCounts();
        Set<Map.Entry<Rank, Integer>> entries = counts.entrySet();
        for (Map.Entry<Rank, Integer> entry : entries) {
            Rank rank = entry.getKey();
            if (rank.isMatchBonus()) {
                System.out.println(rank.getMatchCount() + "개 일치, 보너스 볼 일치 (" + rank.getFormattedPrize() + "원) - " + entry.getValue() + "개");
            } else if (rank == Rank.NONE) {
                System.out.println();
            } else {
                System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getFormattedPrize() + "원) - " + entry.getValue() + "개");
            }
        }
        System.out.println("총 수익률은 " + result.calculatePrizeRate() + "%입니다.");
    }
}
