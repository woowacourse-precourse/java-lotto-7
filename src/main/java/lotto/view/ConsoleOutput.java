package lotto.view;

import lotto.LottoTicket;
import lotto.Rank;
import lotto.WinningResult;

import java.util.Map;
import java.util.Set;

public class ConsoleOutput {
    public void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println("\n" + lottoTicket.getLottoQuantity() + "개를 구매했습니다.");
        lottoTicket.getLottos().forEach(
                lotto -> System.out.println(lotto.getNumbers())
        );
    }

    public void printPrizeStatistics(WinningResult result) {
        System.out.println("당첨통계");
        System.out.println("---");
        renderPrizeStatistics(result);
        System.out.println("총 수익률은 " + result.calculateTotalPrizeRate() + "%입니다.");
    }

    private void renderPrizeStatistics(WinningResult result) {
        Map<Rank, Integer> counts = result.getCounts();
        Set<Map.Entry<Rank, Integer>> entries = counts.entrySet();
        for (Map.Entry<Rank, Integer> entry : entries) {
            Rank rank = entry.getKey();
            printRankCount(entry, rank);
        }
    }

    private static void printRankCount(Map.Entry<Rank, Integer> entry, Rank rank) {
        if (rank.isMatchBonus()) {
            System.out.println(rank.getMatchCount() + "개 일치, 보너스 볼 일치 (" + rank.getFormattedPrize() + "원) - " + entry.getValue() + "개");
            return;
        }
        if (rank == Rank.NONE) {
            System.out.println();
            return;
        }
        System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getFormattedPrize() + "원) - " + entry.getValue() + "개");
    }
}
