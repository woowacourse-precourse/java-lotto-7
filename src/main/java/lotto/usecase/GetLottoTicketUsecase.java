package lotto.usecase;

import lotto.dto.TicketResponse;
import lotto.service.ticket.ReadTicketService;

public class GetLottoTicketUsecase {
    private final ReadTicketService readTicketService;

    public GetLottoTicketUsecase(ReadTicketService readTicketService) {
        this.readTicketService = readTicketService;
    }

    public TicketResponse execute(Long ticketId) {
        return TicketResponse.from(readTicketService.getById(ticketId));
    }
}
