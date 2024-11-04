package lotto.application.ticket.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.application.ticket.domain.ticket.Lotto;
import lotto.application.ticket.domain.ticket.Ticket;

public record TicketResponse(
        int lottosSize,
        List<Lotto> lottos,
        int totalPrice
) {

    public static TicketResponse from(Ticket ticket) {
        return new TicketResponse(ticket.getLottosSize(), ticket.getLottosValue(), ticket.getTotalPrice());

    }

    public List<List<Integer>> getLottosValue() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

}
