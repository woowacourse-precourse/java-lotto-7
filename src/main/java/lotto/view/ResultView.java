package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printLottoTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public static void printResult(Map<Rank, Integer> result) {
        System.out.println("당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.printf("%s (%,d원) - %d개\n", rank.getDescription(), rank.getPrize(), result.getOrDefault(rank, 0));
            }
        }
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}
