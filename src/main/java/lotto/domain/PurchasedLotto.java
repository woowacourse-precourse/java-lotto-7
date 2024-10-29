package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class PurchasedLotto {
    private final List<Lotto> purchasedLottos;

    public PurchasedLotto(final List<Lotto> lottos) {
        this.purchasedLottos = lottos;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}
