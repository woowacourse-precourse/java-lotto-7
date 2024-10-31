package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public void addLotto(final Lotto lotto) {
        lottoTickets.add(lotto);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
