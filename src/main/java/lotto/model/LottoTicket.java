package lotto.model;

import java.util.List;
import lotto.Lotto;
import lotto.util.Validator;

public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
