package lotto.application.ticket.repository;

import static lotto.application.ticket.repository.TicketCommonStorage.getTicketCommonStorage;

import java.util.concurrent.ConcurrentHashMap;
import lotto.application.ticket.domain.ticket.Ticket;

public class TicketWriteRepository {

    private final ConcurrentHashMap repository = getTicketCommonStorage();

    public TicketWriteRepository() {
    }

    public Long save(Ticket ticket) {
        repository.put(ticket.getId(), ticket);

        return ticket.getId();
    }

}
