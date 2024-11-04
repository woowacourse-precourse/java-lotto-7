package lotto.domain;

import lotto.domain.Lotto;

import java.util.List;

public class PurchasedLottos {
    private final List<Lotto> purchasedLottos;

    public PurchasedLottos(List<Lotto> lotto){
        this.purchasedLottos = lotto;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}
