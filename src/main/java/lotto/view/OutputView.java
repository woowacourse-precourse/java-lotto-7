package lotto.view;

import lotto.utils.StringParser;

import java.util.List;

public class OutputView {
    private static final String TICKET_PURCHASE_MESSAGE = "%d개를 구매했습니다.";

    public static void printTicketsInfo(List<List<Integer>> tickets) {
        System.out.printf(TICKET_PURCHASE_MESSAGE, tickets.size());
        tickets.forEach(OutputView::printTicketInfo);
    }

    private static void printTicketInfo(List<Integer> ticket) {
        String ticketString = StringParser.formatLottoNumbers(ticket);
        System.out.println(ticketString);
    }
}
