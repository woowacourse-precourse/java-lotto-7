package lotto.service;

import lotto.model.Money;
import lotto.model.Ticket;

public class TicketService {
    private Ticket ticket;

    public void createTicket(int amount) {
        Money money = Money.of(amount);
        this.ticket = money.toTickets();
    }

    public int getTicketCount() {
        return ticket.ticketCount();
    }
}
