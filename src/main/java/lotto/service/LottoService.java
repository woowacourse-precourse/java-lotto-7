package lotto.service;

import lotto.domain.LottoGroups;
import lotto.domain.LottoMachine;
import lotto.domain.LottoSeller;
import lotto.domain.Money;
import lotto.domain.strategy.NumberGenerationStrategy;

public class LottoService {
    public LottoGroups purchaseLottos(Money lottoPurchaseMoney,
                                      NumberGenerationStrategy numberGenerationStrategy) {
        LottoSeller lottoSeller = new LottoSeller(new LottoMachine());
        return lottoSeller.sellUntilNoMoney(lottoPurchaseMoney, numberGenerationStrategy);
    }
}
