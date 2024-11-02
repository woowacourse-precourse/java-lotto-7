package lotto.repository.ticket;

import static lotto.repository.ticket.TicketCommonStorage.getRepository;

import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.ticket.Ticket;

public class TicketWriteRepository {

    private final ConcurrentHashMap repository = getRepository();

    public TicketWriteRepository() {
    }

    public Long save(Ticket ticket) {
        repository.put(ticket.getId(), ticket);

        return ticket.getId();
    }

}
