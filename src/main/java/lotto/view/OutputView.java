package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLottoTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
    }

    public static void printResult(LottoResult result) {
        System.out.println("당첨 통계\n---");
        Map<Rank, Integer> matchCount = result.getMatchCount();

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.printf("%s - %d개\n", rank.getDescription(), matchCount.getOrDefault(rank, 0));
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", result.getProfitRate());
    }
}
