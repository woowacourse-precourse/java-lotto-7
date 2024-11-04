package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> tickets;

    public LottoTickets() {
        this.tickets = new ArrayList<>();
    }

    public void save(final Lotto issuedLotto) {
        tickets.add(issuedLotto);
    }

    public List<Lotto> findAll() {
        return Collections.unmodifiableList(tickets);
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
                "tickets=" + tickets +
                '}';
    }

}
