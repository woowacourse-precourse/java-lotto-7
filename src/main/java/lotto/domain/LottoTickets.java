package lotto.domain;

import java.util.List;

public class LottoTickets {
    List<Lotto> tickets;

    private LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets of(List<Lotto> tickets) {
        return new LottoTickets(tickets);
    }

    public int getCount() {
        return tickets.size();
    }

    public List<String> getLottoNumbers() {
        return tickets.stream()
                .map(Object::toString)
                .toList();
    }
}
