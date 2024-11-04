package lotto.model;

import java.util.List;

public class LottoBundle {
    private final List<Lotto> purchasedLottos;

    public LottoBundle(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }


}
