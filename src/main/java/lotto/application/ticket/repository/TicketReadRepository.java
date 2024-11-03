package lotto.application.ticket.repository;


import static lotto.application.ticket.repository.TicketCommonStorage.getTicketCommonStorage;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import lotto.application.ticket.domain.ticket.Ticket;

public class TicketReadRepository {
    private final ConcurrentHashMap repository = getTicketCommonStorage();

    public TicketReadRepository() {
    }

    public Optional<Ticket> findById(Long ticketId) {
        return Optional.ofNullable((Ticket) repository.get(ticketId));
    }
}
