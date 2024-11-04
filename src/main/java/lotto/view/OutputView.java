package lotto.view;

import lotto.constants.WinningRank;
import lotto.domain.Lotto;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPurchasedTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
    }

    public static void printResults(Map<String, Integer> resultCounts, double roi) {
        System.out.println("당첨 통계\n---");
        for (WinningRank rank : WinningRank.values()) {
            if (resultCounts.containsKey(rank)) {
                System.out.println(rank.getDescription() + " - " + resultCounts.get(rank) + "개");
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", roi);
    }
}
