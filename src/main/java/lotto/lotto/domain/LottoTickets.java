package lotto.lotto.domain;

import java.util.List;

public class LottoTickets {
    private final List<Lotto> tickets;
    private LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
        sort();
    }
    public static LottoTickets of(List<Lotto> tickets) {
        return new LottoTickets(tickets);
    }
    private void sort() {
        tickets.forEach(Lotto::sort);
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
