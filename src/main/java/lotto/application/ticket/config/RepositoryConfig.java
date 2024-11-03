package lotto.application.ticket.config;

import lotto.application.prize.repository.paymnet.PaymentWriteRepository;
import lotto.application.ticket.repository.TicketReadRepository;
import lotto.application.ticket.repository.TicketWriteRepository;

public class RepositoryConfig {

    private final TicketWriteRepository ticketWriteRepository;
    private final TicketReadRepository ticketReadRepository;
    private final PaymentWriteRepository paymentWriteRepository;

    public RepositoryConfig(TicketWriteRepository ticketWriteRepository, TicketReadRepository ticketReadRepository,
                            PaymentWriteRepository paymentWriteRepository) {
        this.ticketWriteRepository = ticketWriteRepository;
        this.ticketReadRepository = ticketReadRepository;
        this.paymentWriteRepository = paymentWriteRepository;
    }

    public TicketWriteRepository getTicketWriteRepository() {
        return ticketWriteRepository;
    }

    public TicketReadRepository getTicketReadRepository() {
        return ticketReadRepository;
    }

    public PaymentWriteRepository getPaymentWriteRepository() {
        return paymentWriteRepository;
    }
}
