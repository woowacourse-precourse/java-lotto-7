package lotto.domain;

import java.util.Collections;
import java.util.List;

public class PurchasedLottos {
    private final List<Lotto> lottos;

    private PurchasedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static PurchasedLottos of(List<Lotto> lottos) {
        return new PurchasedLottos(lottos);
    }

    public List<Lotto> getLottosAsUnmodifiableList() {
        return Collections.unmodifiableList(lottos); // unmodifiableList 반환
    }
}
