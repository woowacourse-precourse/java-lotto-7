package lotto.domain;

import java.util.List;

// 로또 객체를 가지는 일급 컬렉션
public class LottoTickets {

    private final List<Lotto> tickets;

    public LottoTickets(final List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
