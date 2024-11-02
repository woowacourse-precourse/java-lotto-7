package lotto.controller;

import lotto.domain.common.ThousandWons.ThousandWons;
import lotto.dto.TicketResponse;
import lotto.usecase.CreateLottoTicketUsecase;
import lotto.usecase.GetLottoTicketUsecase;
import lotto.view.input.TicketInputView;
import lotto.view.output.TicketOutputView;

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
