package lotto.service;

import java.util.Map;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoSeller;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Ranking;
import lotto.domain.WinningLotto;
import lotto.domain.strategy.NumberGenerationStrategy;

public class LottoService {

    private final NumberGenerationStrategy numberGenerationStrategy;

    public LottoService(NumberGenerationStrategy numberGenerationStrategy) {
        this.numberGenerationStrategy = numberGenerationStrategy;
    }

    public Lottos purchaseLottos(Money lottoPurchaseMoney) {
        LottoSeller lottoSeller = new LottoSeller(new LottoMachine());
        return lottoSeller.sellUntilNoMoney(lottoPurchaseMoney, numberGenerationStrategy);
    }

    public LottoResult calculateLottoResult(Lottos purchasedLottos, WinningLotto winningLotto) {
        Map<Ranking, Integer> lottoResult = purchasedLottos.calculateLottoResult(winningLotto);
        return LottoResult.from(lottoResult);
    }
}
