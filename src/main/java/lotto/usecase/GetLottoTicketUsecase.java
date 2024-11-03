package lotto.usecase;

import lotto.application.ticket.dto.TicketResponse;
import lotto.application.ticket.service.TicketReadService;

public class GetLottoTicketUsecase {
    private final TicketReadService ticketReadService;

    public GetLottoTicketUsecase(TicketReadService ticketReadService) {
        this.ticketReadService = ticketReadService;
    }

    public TicketResponse execute(Long ticketId) {
        return TicketResponse.from(ticketReadService.getById(ticketId));
    }
}
