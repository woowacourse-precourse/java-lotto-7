package lotto.util;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class ResultPrinter {

    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTickets.size());
        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public static void printResults(Map<Rank, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.MISS) {
                System.out.printf("%d개 일치%s (%s원) - %d개%n",
                        rank.getMatchCount(), (rank == Rank.SECOND ? ", 보너스 볼 일치" : ""),
                        String.format("%,d", rank.getPrize()),
                        results.getOrDefault(rank, 0)
                );
            }
        }
    }


    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
