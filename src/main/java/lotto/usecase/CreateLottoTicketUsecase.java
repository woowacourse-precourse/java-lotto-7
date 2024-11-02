package lotto.usecase;

import lotto.domain.common.ThousandWons.ThousandWons;
import lotto.domain.payment.LottoQuantity;
import lotto.domain.ticket.Lottos;
import lotto.service.payment.PaymentService;
import lotto.service.ticket.LottoService;
import lotto.service.ticket.WriteTicketService;

public class CreateLottoTicketUsecase {
    private final PaymentService paymentService;
    private final LottoService lottoService;
    private final WriteTicketService writeTicketService;

    public CreateLottoTicketUsecase(PaymentService paymentService,
                                    LottoService lottoService,
                                    WriteTicketService writeTicketService) {

        this.paymentService = paymentService;
        this.lottoService = lottoService;
        this.writeTicketService = writeTicketService;
    }

    public Long execute(ThousandWons krMoney) {
        LottoQuantity lottoQuantity = paymentService.pay(krMoney);
        Lottos lottos = lottoService.create(lottoQuantity);
        Long ticketId = writeTicketService.create(lottos);

        return ticketId;
    }

}
