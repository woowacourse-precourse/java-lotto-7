package lotto.domain;

import java.util.Collections;
import java.util.List;

public class PurchasedLottos {

    private final List<Lotto> lottos;

    public PurchasedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }
}
