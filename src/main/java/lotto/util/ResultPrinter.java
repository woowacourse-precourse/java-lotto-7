package lotto.util;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class ResultPrinter {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.%n";
    private static final String TICKET_NUMBERS_FORMAT = "%s%n";
    private static final String RESULT_HEADING = "당첨 결과:";
    private static final String MATCH_RESULT_FORMAT = "%d개 일치%s (%s원) - %d개%n";
    private static final String BONUS_MATCH = ", 보너스 볼 일치";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.%n";

    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.printf(PURCHASE_MESSAGE, lottoTickets.size());
        for (Lotto ticket : lottoTickets) {
            System.out.printf(TICKET_NUMBERS_FORMAT, ticket.getNumbers());
        }
    }

    public static void printResults(Map<Rank, Integer> results) {
        System.out.println(RESULT_HEADING);

        for (Rank rank : Rank.values()) {
            if (rank != Rank.MISS) {
                System.out.printf(
                        MATCH_RESULT_FORMAT,
                        rank.getMatchCount(), // 일치 개수를 rank.getMatchCount()로 가져옴
                        (rank == Rank.SECOND ? BONUS_MATCH : ""),
                        String.format("%,d", rank.getPrize()),
                        results.getOrDefault(rank, 0)
                );
            }
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_FORMAT, profitRate);
    }
}
