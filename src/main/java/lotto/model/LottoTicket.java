package lotto.model;

import java.util.List;
import lotto.Lotto;

public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottosCount() {
        return lottos.size();
    }
}
