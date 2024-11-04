package lotto.domain.model;

import lotto.util.ErrorMessages;

import java.util.List;
import java.util.Objects;

public class LottoTickets {
    private final List<Lotto> tickets;

    public LottoTickets(List<Lotto> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_LOTTO_TICKET_LIST.getMessage());
        }
        this.tickets = tickets;
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets);
    }
}