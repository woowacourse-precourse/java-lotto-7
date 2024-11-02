package lotto.model;

import lotto.vo.Ticket;

import java.util.List;

public class TicketManager { // TODO: 이름 개선
    private final int ticketAmount;
    private final List<Ticket> tickets;

    public TicketManager(int ticketAmount, List<Ticket> tickets) {
        this.ticketAmount = ticketAmount;
        this.tickets = tickets;
    }
}
