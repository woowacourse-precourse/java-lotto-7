package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Tickets {
    private final List<Ticket> tickets;

    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    

    public int getTicketCount() {
        return tickets.size();
    }

    public void add(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public int getAutoTicketCount() {
        return (int) tickets.stream()
                .filter(Ticket::isAuto)
                .count();
    }

    public int getManualTicketCount() {
        return (int) tickets.stream()
                .filter(Predicate.not(Ticket::isAuto))
                .count();
    }

}
