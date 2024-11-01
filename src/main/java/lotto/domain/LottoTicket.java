package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> tickets;

    public LottoTicket(List<Lotto> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    public static LottoTicket from(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(Lotto.from());
        }
        return new LottoTicket(tickets);
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    public int size() {
        return tickets.size();
    }
}
