package lotto.model.person;

import lotto.model.lotto.Lottos;

public class LottoBuyer {
    private Lottos lottos;

    public void buyLotto(final int money, final LottoSeller lottoSeller) {
        this.lottos = lottoSeller.sellTo(money);
    }

    public int getLottoCount() {
        return lottos.calculateLottoCount();
    }

    public Lottos getLottos() {
        return lottos;
    }
}
