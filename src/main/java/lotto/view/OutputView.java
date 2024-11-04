package lotto.view;

import lotto.utils.MatchCountMessage;
import lotto.utils.StringParser;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    public static final String COUNT_UNIT = "개";
    private static final String TOTAL_PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String TICKET_PURCHASE_MESSAGE = "%d개를 구매했습니다.";

    public static void printResult(int[] winningCount, double totalProfitRate) {
        printWinningStatistics(winningCount);
        printTotalProfitRate(totalProfitRate);
    }

    public static void printTicketsInfo(List<List<Integer>> tickets) {
        System.out.printf(TICKET_PURCHASE_MESSAGE, tickets.size());
        tickets.forEach(OutputView::printTicketInfo);
    }

    private static void printTicketInfo(List<Integer> ticket) {
        String ticketString = StringParser.formatLottoNumbers(ticket);
        System.out.println(ticketString);
    }

    private static void printWinningStatistics(int[] winningCount) {
        int length = MatchCountMessage.values().length;
        IntStream.range(0, length)
                .forEach(i -> System.out.println(MatchCountMessage.values()[i].getMessage() + winningCount[length - i] + COUNT_UNIT));
    }

    private static void printTotalProfitRate(double totalProfitRate) {
        System.out.printf(TOTAL_PROFIT_RATE_MESSAGE, totalProfitRate);
    }
}
