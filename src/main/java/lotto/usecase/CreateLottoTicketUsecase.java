package lotto.usecase;

import lotto.domain.common.ThousandWons.ThousandWons;
import lotto.domain.payment.LottoQuantity;
import lotto.domain.ticket.Lottos;
import lotto.service.payment.PaymentService;
import lotto.service.service.LottoService;
import lotto.service.service.TicketService;

public class CreateLottoTicketUsecase {
    private final PaymentService paymentService;
    private final LottoService lottoService;
    private final TicketService ticketService;

    public CreateLottoTicketUsecase(PaymentService paymentService,
                                    LottoService lottoService,
                                    TicketService ticketService) {

        this.paymentService = paymentService;
        this.lottoService = lottoService;
        this.ticketService = ticketService;
    }

    public Long execute(ThousandWons krMoney) {
        LottoQuantity lottoQuantity = paymentService.pay(krMoney);
        Lottos lottos = lottoService.create(lottoQuantity);
        Long ticketId = ticketService.create(lottos);

        return ticketId;
    }

}
