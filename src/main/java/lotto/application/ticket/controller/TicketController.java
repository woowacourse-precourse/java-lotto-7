package lotto.application.ticket.controller;

import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.ticket.domain.payment.LottoQuantity;
import lotto.application.ticket.dto.TicketResponse;
import lotto.application.ticket.service.TicketReadService;
import lotto.application.ticket.service.TicketWriteService;
import lotto.application.ticket.service.payment.PaymentWriteService;

public class TicketController {
    private final PaymentWriteService paymentWriteService;
    private final TicketWriteService ticketWriteService;
    private final TicketReadService ticketReadService;

    public TicketController(PaymentWriteService paymentWriteService,
                            TicketWriteService ticketWriteService,
                            TicketReadService ticketReadService) {

        this.paymentWriteService = paymentWriteService;
        this.ticketWriteService = ticketWriteService;
        this.ticketReadService = ticketReadService;
    }

    public Long create(ThousandWons krMoney) {
        LottoQuantity lottoQuantity = paymentWriteService.pay(krMoney);
        Long ticketId = ticketWriteService.create(lottoQuantity);

        return ticketId;
    }

    public TicketResponse getTicket(Long createdId) {
        return ticketReadService.getTicket(createdId);
    }

}
