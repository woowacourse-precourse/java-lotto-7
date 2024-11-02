package lotto.dto;

import java.util.List;
import lotto.domain.CustomerLotto;
import lotto.domain.Lotto;

public record GeneratedTickets(List<Lotto> tickets) {
    public static GeneratedTickets from(CustomerLotto customerLotto) {
        return new GeneratedTickets(customerLotto.getTickets());
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    public int getTicketCount() {
        return tickets.size();
    }
}
