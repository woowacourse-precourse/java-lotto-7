package lotto.usecase;

import lotto.domain.common.ThousandWons.ThousandWons;
import lotto.domain.payment.LottoQuantity;
import lotto.domain.ticket.Lottos;
import lotto.service.payment.PaymentWriteService;
import lotto.service.ticket.LottoWriteService;
import lotto.service.ticket.TicketWriteService;

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
