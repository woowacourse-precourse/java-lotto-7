package lotto.application.ticket.config;

import lotto.application.ticket.view.input.TicketInputView;
import lotto.application.ticket.view.output.TicketOutputView;

public class ViewConfig {
    private final TicketInputView ticketInputView;
    private final TicketOutputView ticketOutputView;

    public ViewConfig(TicketInputView ticketInputView, TicketOutputView ticketOutputView) {
        this.ticketInputView = ticketInputView;
        this.ticketOutputView = ticketOutputView;
    }

}
