package lotto.application.ticket.repository;

import java.util.concurrent.ConcurrentHashMap;
import lotto.application.ticket.domain.ticket.Ticket;

public class TicketCommonStorage {
    private static final ConcurrentHashMap<Long, Ticket> repository = new ConcurrentHashMap<>();

    private TicketCommonStorage() {
    }

    public static ConcurrentHashMap<Long, Ticket> getTicketCommonStorage() {
        return repository;
    }

    public static void clear() {
        repository.clear();
    }

}
