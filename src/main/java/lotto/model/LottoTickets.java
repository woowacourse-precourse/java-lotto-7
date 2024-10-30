package lotto.model;

import java.util.List;

public class LottoTickets {

    private final List<Lotto> tickets;

    public LottoTickets(final List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public int size() {
        return tickets.size();
    }
}
