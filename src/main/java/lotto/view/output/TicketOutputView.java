package lotto.view.output;

public class TicketOutputView {
    private static final String TICKET_MESSAGE = "%d개를 구매했습니다.%n";

    public static void showTicket(int ticket) {
        System.out.printf(TICKET_MESSAGE, ticket);
    }
}
