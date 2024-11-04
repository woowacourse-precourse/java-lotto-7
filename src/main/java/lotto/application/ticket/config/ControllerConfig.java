package lotto.application.ticket.config;

import lotto.application.ticket.controller.TicketController;
import lotto.application.ticket.service.TicketReadService;
import lotto.application.ticket.service.TicketWriteService;
import lotto.application.ticket.service.payment.PaymentWriteService;

public class ControllerConfig {
    private final TicketController ticketController;

    public ControllerConfig(PaymentWriteService paymentWriteService,
                            TicketWriteService ticketWriteService,
                            TicketReadService ticketReadService) {

        this.ticketController = new TicketController(
                paymentWriteService,
                ticketWriteService,
                ticketReadService
        );
    }

    public TicketController getTicketController() {
        return ticketController;
    }
}
