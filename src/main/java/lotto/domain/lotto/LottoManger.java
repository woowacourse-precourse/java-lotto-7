package lotto.domain.lotto;

import lotto.domain.lotto.factory.LottoFactory;

public class LottoManger {

    private final LottoFactory lottoFactory;
    private final Lottos lottos;

    public LottoManger(LottoFactory lottoFactory, Lottos lottos) {
        this.lottoFactory = lottoFactory;
        this.lottos = lottos;
    }
}
