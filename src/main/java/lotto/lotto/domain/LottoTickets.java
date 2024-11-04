package lotto.lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> tickets;
    private LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }
    public static LottoTickets of(List<Lotto> tickets) {
        return new LottoTickets(tickets);
    }
    public List<Lotto> info() {
        return Collections.unmodifiableList(tickets);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        tickets.forEach(
                (lotto) -> sb.append(lotto).append("\n")
        );
        return sb.toString();
    }
}
