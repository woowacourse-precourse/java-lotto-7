package lotto.domain;

import java.util.Collections;
import java.util.List;

public class PurchasedLottos {

    private final List<Lotto> lottos;

    private PurchasedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static PurchasedLottos from(List<Lotto> purchasedLottos) {
        return new PurchasedLottos(purchasedLottos);
    }

    public int getQuantity() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
