package lotto.model.lottery;

import static lotto.common.Constants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.model.payment.Payment;

public class MockPurchasedLotto extends PurchasedLotto {

    private final List<Lotto> lottos;

    public MockPurchasedLotto(Payment payment) {
        super(new ArrayList<>());
        lottos = new ArrayList<>(payment.get() / LOTTO_PRICE);
    }

    @Override
    public List<Lotto> get() {
        return this.lottos;
    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
