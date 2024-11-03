package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGroup {
    private final List<LottoTicket> tickets;

    public LottoTicketGroup() {
        this.tickets = new ArrayList<>();
    }

    public void addTicket(LottoTicket ticket) {
        tickets.add(ticket);
    }

    public void printAllTickets() {
        for (LottoTicket ticket : tickets) {
            ticket.printLottoNumbers();
        }
    }
}
