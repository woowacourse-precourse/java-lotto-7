package lotto.model;

import java.util.List;

public class Lottos {
    private final List<Lotto> tickets;

    public Lottos(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public List<Lotto> getTickets() {
        return List.copyOf(tickets);
    }
}
