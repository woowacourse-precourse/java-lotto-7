package lotto.store;

import lotto.money.Money;
import lotto.money.ProductPrice;

import java.util.LinkedList;
import java.util.List;

public class LottoStore {
    private static final ProductPrice lottoPrice = new ProductPrice(1_000);
    private final LottoGenerator lottoGenerator;

    public LottoStore(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> sale(Money money) {
        if(lottoPrice.hasChange(money))
            throw new IllegalArgumentException("거스름돈이 발생합니다.");

        return createLotto(lottoPrice.countPurchasableProduct(money));
    }

    private List<Lotto> createLotto(final int purchasableProduct) {
        List<Lotto> result = new LinkedList<>();
        for (int i = 0; i < purchasableProduct ; i++) {
            result.add(lottoGenerator.random());
        }
        return result;
    }
}
