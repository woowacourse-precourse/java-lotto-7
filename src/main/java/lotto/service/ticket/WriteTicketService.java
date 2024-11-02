package lotto.service.ticket;

import lotto.domain.ticket.Lottos;
import lotto.domain.ticket.Ticket;
import lotto.repository.ticket.WriteTicketRepository;
import lotto.service.IdGenerator;

public class WriteTicketService {

    private final WriteTicketRepository repository;
    private final IdGenerator idGenerator;

    public WriteTicketService(WriteTicketRepository repository, IdGenerator idGenerator) {
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
