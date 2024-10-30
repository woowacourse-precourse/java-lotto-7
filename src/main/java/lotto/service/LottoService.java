package lotto.service;

import lotto.model.lotto.Lottos;
import lotto.model.lotto.generator.LottoGenerator;
import lotto.model.money.Money;

public class LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoService(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos offerLottos(final Money money) {
        long count = money.calculatePurchasedLottoCount();
        return lottoGenerator.generate(count);
    }
}
