package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> tickets = new ArrayList<>();


    public void add(LottoTicket ticket) {
        this.tickets.add(ticket);
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
                "tickets=" + tickets +
                '}';
    }
}
