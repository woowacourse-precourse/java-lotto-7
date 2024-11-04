package lotto.store;

import lotto.money.Money;
import lotto.store.lotto.Lotto;
import lotto.store.lotto.LottoGenerator;

import java.util.LinkedList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_AMOUNT = 1_000;
    private static final Money LOTTO_MONEY_UNIT = new Money(LOTTO_AMOUNT);
    private final LottoGenerator lottoGenerator;

    public LottoStore(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> sale(Money money) {
        return createLotto(money.countBundle(LOTTO_MONEY_UNIT));
    }

    private List<Lotto> createLotto(final int purchasableProduct) {
        List<Lotto> result = new LinkedList<>();
        for (int i = 0; i < purchasableProduct ; i++) {
            result.add(lottoGenerator.random());
        }
        return result;
    }
}
