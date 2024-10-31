package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottoTickets.add(lotto);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

}
