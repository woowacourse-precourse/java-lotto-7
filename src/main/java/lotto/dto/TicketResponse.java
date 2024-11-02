package lotto.dto;

import java.util.List;
import lotto.domain.ticket.Ticket;

public record TicketResponse(
        int count,
        List<List<Integer>> ticket
) {

    public static TicketResponse from(Ticket byId) {
        return null;
    }

    public TicketResponse getId() {
        return null;
    }

    public Ticket getTicket() {
        return null;
    }
}
