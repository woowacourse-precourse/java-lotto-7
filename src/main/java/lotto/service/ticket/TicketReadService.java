package lotto.service.ticket;

import lotto.domain.ticket.Ticket;
import lotto.repository.ticket.TicketReadRepository;

public class TicketReadService {
    private final TicketReadRepository repository;

    public TicketReadService(TicketReadRepository repository) {
        this.repository = repository;
    }

    public Ticket getById(Long ticketId) {
        return repository.findById(ticketId).orElseThrow(() -> new IllegalArgumentException("존재 하지 않는 티켓 ID 입니다."));
    }

}
