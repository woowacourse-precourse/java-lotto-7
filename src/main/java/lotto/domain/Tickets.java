package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Tickets {

    private final List<Ticket> tickets;

    private Tickets(final List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static Tickets of(final int count) {
        return new Tickets(generateTicketList(count));
    }

    public List<Ticket> getTickets() {
        return List.copyOf(tickets);
    }

    private static List<Ticket> generateTicketList(int count) {
        List<Ticket> ticketList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            ticketList.add(
                    Ticket.of(
                            LottoNumberGenerator.generateWinningNumbers(),
                            LottoNumberGenerator.generateBonusNumber()
                    )
            );
        }

        return ticketList;
    }
}
