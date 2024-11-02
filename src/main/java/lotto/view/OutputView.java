package lotto.view;

import lotto.dto.GeneratedTickets;

public class OutputView {

    public static final String PURCHASED_TICKET_MESSAGE = "%d개를 구매했습니다.";

    public void printGeneratedTickets(GeneratedTickets generatedTicket) {
        System.out.println(String.format(PURCHASED_TICKET_MESSAGE, generatedTicket.ticketCount()));
        generatedTicket.getTickets().forEach(System.out::println);
    }
}
