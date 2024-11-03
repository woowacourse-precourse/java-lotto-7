package lotto.usecase;

import lotto.application.common.ThousandWons.ThousandWons;
import lotto.application.ticket.controller.TicketController;
import lotto.application.ticket.dto.TicketResponse;
import lotto.application.ticket.view.input.TicketInputView;
import lotto.application.ticket.view.output.TicketOutputView;

public class CreateTicketUsecase {

    private final TicketInputView inputView;
    private final TicketOutputView outputView;
    private final TicketController controller;

    public CreateTicketUsecase(
            TicketInputView inputView,
            TicketOutputView outputView,
            TicketController controller
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.controller = controller;
    }

    public TicketResponse execute() {
        ThousandWons money = inputView.initialize();

        Long createdId = controller.create(money);
        TicketResponse ticketResponse = controller.getTicket(createdId);

        outputView.show(ticketResponse);
        return ticketResponse;
    }
}
