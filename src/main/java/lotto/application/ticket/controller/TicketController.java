package lotto.application.ticket.controller;

import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.ticket.dto.TicketResponse;
import lotto.application.ticket.view.input.TicketInputView;
import lotto.application.ticket.view.output.TicketOutputView;
import lotto.usecase.CreateLottoTicketUsecase;
import lotto.usecase.GetLottoTicketUsecase;

public class TicketController {
    private final TicketInputView inputView;
    private final TicketOutputView outputView;
    private final CreateLottoTicketUsecase createLottoTicketUsecase;
    private final GetLottoTicketUsecase getLottoTicketUsecase;

    public TicketController(TicketInputView inputView,
                            TicketOutputView outputView,
                            CreateLottoTicketUsecase createLottoTicketUsecase,
                            GetLottoTicketUsecase getLottoTicketUsecase) {

        this.inputView = inputView;
        this.outputView = outputView;
        this.createLottoTicketUsecase = createLottoTicketUsecase;
        this.getLottoTicketUsecase = getLottoTicketUsecase;
    }

    public TicketResponse create() {
        ThousandWons krMoney = inputView.initialize();

        Long ticketId = createLottoTicketUsecase.execute(krMoney);
        TicketResponse ticketResponse = getLottoTicketUsecase.execute(ticketId);

        outputView.show(ticketResponse);

        return ticketResponse;
    }

}
