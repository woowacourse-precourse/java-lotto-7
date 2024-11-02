package lotto.repository;

import static lotto.repository.TicketCommonStorage.getRepository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.ticket.Ticket;

public class ReadTicketRepository {
    private final ConcurrentHashMap repository = getRepository();

    private ReadTicketRepository() {
    }

    public Optional<Ticket> findById(Long ticketId) {
        return Optional.of((Ticket) repository.get(ticketId));
    }
}
