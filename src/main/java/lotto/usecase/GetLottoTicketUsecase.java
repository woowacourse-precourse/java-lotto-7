package lotto.usecase;

import lotto.dto.TicketResponse;
import lotto.service.ticket.TicketReadService;

public class GetLottoTicketUsecase {
    private final TicketReadService ticketReadService;

    public GetLottoTicketUsecase(TicketReadService ticketReadService) {
        this.ticketReadService = ticketReadService;
    }

    public TicketResponse execute(Long ticketId) {
        return TicketResponse.from(ticketReadService.getById(ticketId));
    }
}
