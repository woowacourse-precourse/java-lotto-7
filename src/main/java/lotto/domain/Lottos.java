package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private final PurchaseMoney purchaseMoney;

    public Lottos(List<Lotto> lottos, PurchaseMoney purchaseMoney) {
        this.lottos = lottos;
        this.purchaseMoney = purchaseMoney;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getPurchaseMoney() {
        return purchaseMoney.getMoney();
    }
}
