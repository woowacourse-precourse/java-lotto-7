package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class Tickets {
    private final List<Ticket> tickets;

    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getTicketCount() {
        return tickets.size();
    }

    public void add(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public int getManualTicketCount() {
        return (int)tickets.stream()
                .filter(Predicate.not(Ticket::isAuto))
                .count();
    }

}
