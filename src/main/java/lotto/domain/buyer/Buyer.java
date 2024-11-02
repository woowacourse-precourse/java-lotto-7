package lotto.domain.buyer;

import java.util.List;
import java.util.Objects;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

public class Buyer {
    private final PurchaseCount purchaseCount;
    private final Lottos purchasedLottos;

    Buyer(final PurchaseCount purchaseCount, Lottos purchasedLottos) {
        this.purchaseCount = purchaseCount;
        this.purchasedLottos = purchasedLottos;
    }

    public int getPurchaseCount() {
        return purchaseCount.getPurchaseCount();
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos.getLottos();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Buyer otherBuyer = (Buyer) obj;
        return Objects.equals(purchaseCount, otherBuyer.purchaseCount) &&
                Objects.equals(purchasedLottos, otherBuyer.purchasedLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseCount, purchasedLottos);
    }
}
