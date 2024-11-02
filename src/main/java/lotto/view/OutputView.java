package lotto.view;

import static lotto.constant.MessageConstant.*;

import java.util.List;

public class OutputView {

    public void printTicketCount(int count) {
        System.out.println();
        System.out.printf(OUTPUT_PURCHASE_TICKET.getMessage(), count);
        System.out.println();
    }

    public void printTicketNumbers(List<String> tickets) {
        tickets.forEach(ticket -> {
            System.out.printf(OUTPUT_PURCHASE_TICKET_INFO.getMessage(), ticket);
            System.out.println();
        });
    }
}
