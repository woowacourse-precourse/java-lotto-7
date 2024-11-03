package lotto;

import java.util.ArrayList;
import java.util.List;

public class SpyPurchasedLotto extends PurchasedLotto {

    private final List<Lotto> lottos;

    public SpyPurchasedLotto(Payment payment) {
        super(new ArrayList<>());
        lottos = new ArrayList<>(payment.getValue() / 1000);
    }

    @Override
    public List<Lotto> get() {
        return this.lottos;
    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
