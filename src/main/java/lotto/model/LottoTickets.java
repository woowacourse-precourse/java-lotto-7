package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> tickets = new ArrayList<>();

    public LottoTickets(List<List<Integer>> tickets) {
        for (List<Integer> lotto : tickets) {
            this.tickets.add(new Lotto(lotto));
        }
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
