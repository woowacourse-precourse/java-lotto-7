package lotto.application.ticket.config;

import lotto.application.prize.repository.paymnet.PaymentWriteRepository;
import lotto.application.ticket.repository.TicketReadRepository;
import lotto.application.ticket.repository.TicketWriteRepository;
import lotto.application.ticket.service.LottoWriteService;
import lotto.application.ticket.service.NumberGenerator;
import lotto.application.ticket.service.TicketIdGenerator;
import lotto.application.ticket.service.TicketReadService;
import lotto.application.ticket.service.TicketWriteService;
import lotto.application.ticket.service.UniqueNumberGenerator;
import lotto.application.ticket.service.payment.PaymentIdGenerator;
import lotto.application.ticket.service.payment.PaymentWriteService;

public class ServiceConfig {

    private final PaymentWriteService paymentWriteService;
    private final TicketReadService ticketReadService;
    private final TicketWriteService ticketWriteService;

    public ServiceConfig(PaymentWriteRepository paymentWriteRepository,
                         TicketReadRepository ticketReadRepository,
                         TicketWriteRepository ticketWriteRepository) {
        this.paymentWriteService = new PaymentWriteService(
                paymentWriteRepository,
                getPaymentIdGenerator()
        );
        this.ticketReadService = new TicketReadService(ticketReadRepository);
        this.ticketWriteService = new TicketWriteService(
                ticketWriteRepository,
                getLottoWriteService(),
                getTicketIdGenerator()
        );
    }

    public PaymentWriteService getPaymentWriteService() {
        return paymentWriteService;
    }

    public TicketReadService getTicketReadService() {
        return ticketReadService;
    }

    public TicketWriteService getTicketWriteService() {
        return ticketWriteService;
    }

    private LottoWriteService getLottoWriteService() {
        return new LottoWriteService(getNumberGenerator());
    }

    private TicketIdGenerator getTicketIdGenerator() {
        return new TicketIdGenerator();
    }

    private PaymentIdGenerator getPaymentIdGenerator() {
        return new PaymentIdGenerator();
    }

    private NumberGenerator getNumberGenerator() {
        return new UniqueNumberGenerator();
    }
}
