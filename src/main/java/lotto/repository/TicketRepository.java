package lotto.repository;

import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.ticket.Ticket;

public class TicketRepository {

    private final ConcurrentHashMap repository = new ConcurrentHashMap<Long, Ticket>();

    private TicketRepository() {
    }

    public Long save(Ticket ticket) {
        repository.put(ticket.getId(), ticket);
        return ticket.getId();
    }

}
