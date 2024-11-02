package lotto.repository;

import static lotto.repository.TicketCommonStorage.getRepository;

import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.ticket.Ticket;

public class WriteTicketRepository {

    private final ConcurrentHashMap repository = getRepository();

    private WriteTicketRepository() {
    }

    public Long save(Ticket ticket) {
        repository.put(ticket.getId(), ticket);

        return ticket.getId();
    }

}
