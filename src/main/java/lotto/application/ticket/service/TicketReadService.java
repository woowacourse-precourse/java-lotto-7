package lotto.application.ticket.service;

import lotto.application.ticket.domain.ticket.Ticket;
import lotto.application.ticket.repository.TicketReadRepository;

public class TicketReadService {
    private final TicketReadRepository repository;

    public TicketReadService(TicketReadRepository repository) {
        this.repository = repository;
    }

    public Ticket getById(Long ticketId) {
        return repository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재 하지 않는 티켓 ID 입니다."));
    }

}
