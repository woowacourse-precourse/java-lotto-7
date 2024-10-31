package lotto.view;

import java.util.List;

public class OutputView {

    private static final String PURCHASE_TICKET_MESSAGE = "%d개를 구매했습니다.";
    private static final String PURCHASE_TICKET_INFO_MESSAGE = "[%s]";
    private static final String LINE_BREAK = "\n";

    public void printTicketCount(int count) {
        System.out.printf(LINE_BREAK + PURCHASE_TICKET_MESSAGE + LINE_BREAK, count);
    }

    public void printTicketNumbers(List<String> tickets) {
        tickets.forEach(ticket ->
                System.out.printf(PURCHASE_TICKET_INFO_MESSAGE + LINE_BREAK, ticket)
        );
    }
}
