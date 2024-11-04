package lotto.application.ticket.service;

import lotto.application.common.IdGenerator;
import lotto.application.ticket.domain.payment.LottoQuantity;
import lotto.application.ticket.domain.ticket.Lottos;
import lotto.application.ticket.domain.ticket.Ticket;
import lotto.application.ticket.repository.TicketWriteRepository;

public class TicketWriteService {

    private final TicketWriteRepository repository;
    private final LottoWriteService lottoWriteService;

    private final IdGenerator idGenerator;

    public TicketWriteService(TicketWriteRepository repository, LottoWriteService lottoWriteService,
                              IdGenerator idGenerator) {
        this.repository = repository;
        this.lottoWriteService = lottoWriteService;
        this.idGenerator = idGenerator;
    }

    public Long create(LottoQuantity quantity) {
        Lottos lottos = lottoWriteService.create(quantity);
        Ticket ticket = issue(lottos);

        return repository.save(ticket);
    }

    private Ticket issue(Lottos lottos) {
        return Ticket.issue(idGenerator.generate(), lottos);
    }

}
