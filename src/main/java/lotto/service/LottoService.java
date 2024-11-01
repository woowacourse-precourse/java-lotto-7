package lotto.service;

import lotto.domain.LottoGroups;
import lotto.domain.LottoMachine;
import lotto.domain.LottoSeller;
import lotto.domain.Money;
import lotto.domain.strategy.LottoNumberGenerationStrategy;

public class LottoService {
    public LottoGroups purchaseLottos(Money lottoPurchaseMoney,
                                      LottoNumberGenerationStrategy lottoNumberGenerationStrategy) {
        LottoSeller lottoSeller = new LottoSeller(new LottoMachine());
        return lottoSeller.sellUntilNoMoney(lottoPurchaseMoney, lottoNumberGenerationStrategy);
    }
}
