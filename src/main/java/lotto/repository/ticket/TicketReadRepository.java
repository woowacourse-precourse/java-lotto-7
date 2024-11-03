package lotto.repository.ticket;


import static lotto.repository.ticket.TicketCommonStorage.getTicketCommonStorage;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.ticket.Ticket;

public class TicketReadRepository {
    private final ConcurrentHashMap repository = getTicketCommonStorage();

    public TicketReadRepository() {
    }

    public Optional<Ticket> findById(Long ticketId) {
        return Optional.ofNullable((Ticket) repository.get(ticketId));
    }
}
