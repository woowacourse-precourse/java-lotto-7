package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoResult;
import lotto.dto.LottoResults;

public class CustomerLotto {
    private final List<Lotto> tickets;

    private CustomerLotto(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static CustomerLotto of(List<Lotto> tickets) {
        return new CustomerLotto(tickets);
    }

    public LottoResults compareWinningLotto(WinningLotto winningLotto) {
        List<LottoResult> lottoResults = tickets.stream()
                .map(winningLotto::checkLotto)
                .toList();
        return LottoResults.of(lottoResults);
    }

    public List<Lotto> getTickets() {
        return new ArrayList<>(tickets);
    }
}
