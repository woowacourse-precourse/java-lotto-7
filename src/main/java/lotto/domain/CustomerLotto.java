package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoResult;

public class CustomerLotto {
    private final List<Lotto> tickets;

    private CustomerLotto(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static CustomerLotto of(List<Lotto> tickets) {
        return new CustomerLotto(tickets);
    }

    public List<LottoResult> compareWinningLotto(WinningLotto winningLotto) {
        return tickets.stream()
                .map(winningLotto::checkLotto)
                .toList();
    }

    public List<Lotto> getTickets() {
        return new ArrayList<>(tickets);
    }
}
