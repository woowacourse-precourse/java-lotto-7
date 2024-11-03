package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.Lotto;

public class PurchasedLottos {

    private final List<Lotto> purchasedLottos;

    public PurchasedLottos(List<Lotto> lottos) {
        this.purchasedLottos = lottos;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PurchasedLottos comparingPurchasedLottos = (PurchasedLottos) obj;
        return Objects.equals(purchasedLottos, comparingPurchasedLottos.purchasedLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchasedLottos);
    }

    public List<Lotto> get() {
        return purchasedLottos;
    }
}
