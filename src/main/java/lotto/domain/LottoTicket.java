package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> tickets;

    public LottoTicket(List<Lotto> tickets) {
        this.tickets = Collections.unmodifiableList(new ArrayList<>(tickets));
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    public int getTicketCount() {
        return tickets.size();
    }
}
