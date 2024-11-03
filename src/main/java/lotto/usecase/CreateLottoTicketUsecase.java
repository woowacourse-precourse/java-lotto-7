package lotto.usecase;

import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.ticket.domain.payment.LottoQuantity;
import lotto.application.ticket.domain.ticket.Lottos;
import lotto.application.ticket.service.LottoWriteService;
import lotto.application.ticket.service.TicketWriteService;
import lotto.application.ticket.service.payment.PaymentWriteService;

public class CreateLottoTicketUsecase {
    private final PaymentWriteService paymentWriteService;
    private final LottoWriteService lottoWriteService;
    private final TicketWriteService ticketWriteService;

    public CreateLottoTicketUsecase(PaymentWriteService paymentWriteService,
                                    LottoWriteService lottoWriteService,
                                    TicketWriteService ticketWriteService) {

        this.paymentWriteService = paymentWriteService;
        this.lottoWriteService = lottoWriteService;
        this.ticketWriteService = ticketWriteService;
    }

    public Long execute(ThousandWons krMoney) {
        LottoQuantity lottoQuantity = paymentWriteService.pay(krMoney);
        Lottos lottos = lottoWriteService.create(lottoQuantity);
        Long ticketId = ticketWriteService.create(lottos);

        return ticketId;
    }

}
