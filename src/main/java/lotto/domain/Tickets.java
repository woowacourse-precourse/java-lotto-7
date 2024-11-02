package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Tickets {

    private final List<Lotto> tickets;

    public Tickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public int getTicketAmount() {
        return tickets.size();
    }

    public List<Lotto> getUnmodifiableTickets() {
        return Collections.unmodifiableList(tickets);
    }
}
