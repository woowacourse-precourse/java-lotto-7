package lotto.dto;

import java.util.List;
import lotto.domain.CustomerLotto;
import lotto.domain.Lotto;

public record GeneratedTickets(List<Lotto> tickets, int ticketCount) {
    public static GeneratedTickets from(CustomerLotto customerLotto) {
        return new GeneratedTickets(customerLotto.getTickets(), customerLotto.getTickets().size());
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
