package lotto.utils;

import lotto.dto.FormattedTickets;
import lotto.dto.SortedIssuedTickets;

import java.util.List;
import java.util.stream.Collectors;

public class TicketFormatter {

    private TicketFormatter() {
    }

    public static FormattedTickets formatTickets(SortedIssuedTickets sortedIssuedTickets) {
        List<String> formattedTickets = sortedIssuedTickets.sortedTickets().stream()
                .map(ticket -> ticket.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]")))
                .collect(Collectors.toList());

        return new FormattedTickets(formattedTickets);
    }
}
