package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> get() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
