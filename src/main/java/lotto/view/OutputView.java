package lotto.view;

import java.util.List;
import lotto.model.Ticket;
import lotto.util.InputParser;

public class OutputView {

    public void print(String message) {
        System.out.println(message);
    }

    public void printMoneyRequest() {
        System.out.println(Outputs.MONEY_REQUEST.getMessage());
    }

    public void printTicketNumbers(List<Ticket> tickets) {
        System.out.println();
        System.out.println(InputParser.getComma(tickets.size()) + Outputs.TICKETS_BOUGHT.getMessage());

        for (Ticket ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void printLottoRequest() {
        System.out.println();
        System.out.println(Outputs.LOTTO_REQUEST.getMessage());
    }
}
