package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;
import java.util.Map;

public class OutputView {
    public static void printLottoTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
    }

    public static void printResult(LottoResult result) {
        System.out.println("당첨 통계\n---");
        Map<Rank, Integer> matchCount = result.getMatchCount();

        System.out.printf("3개 일치 (5,000원) - %d개\n", matchCount.getOrDefault(Rank.FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", matchCount.getOrDefault(Rank.FOURTH, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", matchCount.getOrDefault(Rank.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", matchCount.getOrDefault(Rank.SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", matchCount.getOrDefault(Rank.FIRST, 0));

        System.out.printf("총 수익률은 %.1f%%입니다.%n", result.getProfitRate());
    }
}