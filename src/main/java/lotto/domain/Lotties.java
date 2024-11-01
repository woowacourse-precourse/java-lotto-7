package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotties {
    private final List<Lotto> lottoTickets;

    private Lotties(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static Lotties of(List<Lotto> lottoTickets) {
        return new Lotties(lottoTickets);
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public long size() {
        return lottoTickets.size();
    }
}
