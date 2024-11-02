package lotto.repository.ticket;


import static lotto.repository.ticket.TicketCommonStorage.getRepository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.ticket.Ticket;

public class TicketReadRepository {
    private final ConcurrentHashMap repository = getRepository();

    public TicketReadRepository() {
    }

    public Optional<Ticket> findById(Long ticketId) {
        return Optional.of((Ticket) repository.get(ticketId));
    }
}
