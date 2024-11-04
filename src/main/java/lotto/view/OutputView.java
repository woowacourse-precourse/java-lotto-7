package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    public static void printLottoTickets(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResults(Map<Rank, Integer> results, int purchaseAmount) {
        System.out.println("\n당첨 통계\n---");
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            int count = results.get(rank);
            totalPrize += rank.getPrize() * count;
            System.out.println(rank.getDisplayMessage() + count + "개");
        }
        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}