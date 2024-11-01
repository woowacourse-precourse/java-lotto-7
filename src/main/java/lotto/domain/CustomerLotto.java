package lotto.domain;

import java.util.List;
import lotto.dto.LottoResult;

public class CustomerLotto {
    private final List<Lotto> tickets;

    public CustomerLotto(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public List<LottoResult> compareWinningLotto(WinningLotto winningLotto) {
        return tickets.stream()
                .map(winningLotto::checkLotto)
                .toList();
    }
}
