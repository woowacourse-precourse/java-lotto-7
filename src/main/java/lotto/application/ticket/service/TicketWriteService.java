package lotto.application.ticket.service;

import lotto.application.common.IdGenerator;
import lotto.application.ticket.domain.ticket.Lottos;
import lotto.application.ticket.domain.ticket.Ticket;
import lotto.application.ticket.repository.TicketWriteRepository;

public class TicketWriteService {

    private final TicketWriteRepository repository;
    private final IdGenerator idGenerator;

    public TicketWriteService(TicketWriteRepository repository, IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public Long create(Lottos lottos) {
        Ticket ticket = issue(lottos);

        return repository.save(ticket);
    }

    private Ticket issue(Lottos lottos) {
        return Ticket.issue(idGenerator.generate(), lottos);
    }

}
