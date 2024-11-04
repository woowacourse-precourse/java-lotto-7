package lotto.domain;

import lotto.domain.Lotto;

import java.util.List;

public class PurchasedLottos {
    private final List<Lotto> purchasedLottos;
    private final int purchaseAmount;

    public PurchasedLottos(List<Lotto> lotto, int purchaseAmount) {
        this.purchasedLottos = lotto;
        this.purchaseAmount = purchaseAmount;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
