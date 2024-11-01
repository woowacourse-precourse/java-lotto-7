package lotto.service;

import lotto.domain.ticket.PublishedTicket;
import lotto.domain.ticket.Ticket;
import lotto.repository.TicketRepository;

public class TicketService {

    private final TicketRepository repository;
    private final IdGenerator idGenerator;

    public TicketService(TicketRepository repository, IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public Long create(int lottoCount) {
        Ticket ticket = createTicket(lottoCount);

        Ticket validatedTicket = ticket.validate();
        PublishedTicket publishedTicket = validatedTicket.publish();

        return repository.save(publishedTicket.getTicket());
    }

    private Ticket createTicket(int lottoCount) {
        return Ticket.of(idGenerator.generate(), lottoCount);
    }

}
