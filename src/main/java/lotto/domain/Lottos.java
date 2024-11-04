package lotto.domain;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Lottos {
    private final List<Lotto> tickets;

    public Lottos(List<Lotto> tickets) {
        validate(tickets);
        this.tickets = tickets;
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    private void validate(List<Lotto> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            throw LottoException.from(ErrorMessage.EMPTY_LOTTO_LIST_ERROR);
        }
    }
}
