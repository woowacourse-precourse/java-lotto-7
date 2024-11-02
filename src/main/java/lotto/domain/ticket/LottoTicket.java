package lotto.domain.ticket;

import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class LottoTicket {

    private final List<Lotto> lottoTicket;

    public LottoTicket(List<Lotto> lottos) {
        this.lottoTicket = lottos;
    }

    public List<Lotto> getLottoTicket() {
        return Collections.unmodifiableList(this.lottoTicket);
    }
}
