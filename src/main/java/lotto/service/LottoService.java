package lotto.service;

import lotto.model.Money;
import lotto.model.lotto.LottoMachine;
import lotto.model.lotto.Lottos;

public class LottoService {
    private final LottoMachine lottoMachine;

    public LottoService() {
        this.lottoMachine = new LottoMachine();
    }

    public Lottos generate(final Money money) {
        final int lottoCount = money.calculateLottoCount();
        return lottoMachine.execute(lottoCount);
    }
}
