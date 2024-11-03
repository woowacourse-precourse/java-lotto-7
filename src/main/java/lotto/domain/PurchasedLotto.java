package lotto.domain;

import java.util.List;

public class PurchasedLotto {

    private final List<Lotto> purchasedLottos;

    public PurchasedLotto(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}
