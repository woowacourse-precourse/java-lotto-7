package lotto.domain.lotto;

import lotto.domain.lotto.factory.LottoFactory;

public class LottoMachine {

    private  LottoFactory lottoFactory;
    private  Lottos lottos;

    public LottoMachine(LottoFactory lottoFactory, Lottos lottos) {
        this.lottoFactory = lottoFactory;
        this.lottos = lottos;
    }
}
