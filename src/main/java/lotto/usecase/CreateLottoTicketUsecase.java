package lotto.usecase;

import lotto.LottoCount;
import lotto.ThousandWons;
import lotto.service.PaymentService;
import lotto.service.TicketService;

public class CreateLottoTicketUsecase {
    private final PaymentService paymentService;
    private final TicketService ticketService;

    public CreateLottoTicketUsecase(PaymentService paymentService,
                                    TicketService ticketService) {

        this.paymentService = paymentService;
        this.ticketService = ticketService;
    }

    //TODO: PaymentService - 로또 금액을 지불하라
    //TODO: TicketService - 로또 티켓을 생성하라
    public Long execute(ThousandWons krMoney) {
        LottoCount lottoCount = paymentService.pay(krMoney);
        Long ticketId = ticketService.create(lottoCount);

        return ticketId;
    }
}
