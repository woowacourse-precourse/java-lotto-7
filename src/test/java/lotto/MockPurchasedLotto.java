package lotto;

import java.util.ArrayList;
import java.util.List;

public class MockPurchasedLotto extends PurchasedLotto {

    private final List<Lotto> lottos;

    public MockPurchasedLotto(Payment payment) {
        super(new ArrayList<>());
        lottos = new ArrayList<>(payment.get() / 1000);
    }

    @Override
    public List<Lotto> get() {
        return this.lottos;
    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
