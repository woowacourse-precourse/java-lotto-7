package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoTicket {
    private final List<Lotto> tickets;

    public LottoTicket(List<Lotto> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    public int size() {
        return tickets.size();
    }
}
