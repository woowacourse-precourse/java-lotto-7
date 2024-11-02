package lotto.view;

import lotto.domain.Tickets;

public class OutputView {

    private static final String ENTER = "\n";
    private static final String LOTTERY_AMOUNT_TAIL_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_HEADER = "당첨 통계\n";

    public void printGeneratedTickets(Tickets tickets) {
        int ticketAmount = tickets.getTicketAmount();
        System.out.println(ENTER + ticketAmount + LOTTERY_AMOUNT_TAIL_MESSAGE);
        tickets.getUnmodifiableTickets().forEach(ticket -> System.out.println(ticket.getUnmodifiableNumbers()));
    }
}
