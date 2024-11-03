package lotto.store;

import lotto.money.Money;

import java.util.List;

public class LottoStoreStub extends LottoStore {

    private List<Lotto> testLottos = List.of();

    public LottoStoreStub() {
        super(null);
    }

    public void setSoldLottos(List<Lotto> lottos) {
        testLottos = lottos;
    }

    @Override
    public List<Lotto> sale(Money money) {
        return testLottos;
    }

}
