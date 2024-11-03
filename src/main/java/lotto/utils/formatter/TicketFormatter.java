package lotto.utils.formatter;

import lotto.dto.result.FormattedTickets;
import lotto.dto.result.SortedIssuedTickets;

import java.util.List;
import java.util.stream.Collectors;

public class TicketFormatter {

    private TicketFormatter() {
    }

    private static final String TICKET_OPEN_BRACKET = "[";
    private static final String TICKET_CLOSE_BRACKET = "]";
    private static final String TICKET_DELIMITER = ", ";

    public static FormattedTickets formatTickets(SortedIssuedTickets sortedIssuedTickets) {
        List<String> formattedTickets = sortedIssuedTickets.sortedTickets().stream()
                .map(ticket -> ticket.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(TICKET_DELIMITER, TICKET_OPEN_BRACKET, TICKET_CLOSE_BRACKET)))
                .collect(Collectors.toList());

        return new FormattedTickets(formattedTickets);
    }
}
