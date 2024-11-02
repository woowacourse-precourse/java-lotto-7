package lotto.service;

import lotto.domain.ticket.Lottos;
import lotto.domain.ticket.Ticket;
import lotto.repository.WriteTicketRepository;

public class TicketService {

    private final WriteTicketRepository repository;
    private final IdGenerator idGenerator;

    public TicketService(WriteTicketRepository repository, IdGenerator idGenerator) {
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
