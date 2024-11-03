package lotto.application.ticket.dto;

import java.util.List;
import lotto.application.ticket.domain.ticket.Ticket;

public record TicketResponse(
        int lottosSize,
        List<List<Integer>> lottos
) {

    public static TicketResponse from(Ticket ticket) {
        return new TicketResponse(ticket.getLottosSize(), ticket.getLottosValue());

    }

}
