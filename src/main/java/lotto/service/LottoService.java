package lotto.service;

import lotto.domain.*;
import lotto.domain.constant.Ranking;
import lotto.domain.lottomachine.LottoMachine;

import java.util.EnumMap;

public class LottoService {

    private final LottoMachine lottoMachine;
    private final LottoStore lottoStore;
    private final EarningRateCalculator earningRateCalculator;

    public LottoService(LottoMachine lottoMachine, LottoStore lottoStore, EarningRateCalculator earningRateCalculator) {
        this.lottoMachine = lottoMachine;
        this.lottoStore = lottoStore;
        this.earningRateCalculator = earningRateCalculator;
    }

    public PurchasedLottos purchaseLottos(Integer purchaseAmount) {
        Money money = Money.from(purchaseAmount);

        int quantity = lottoStore.calculateLottoQuantity(money);
        return lottoMachine.issueTickets(quantity);
    }

    public EnumMap<Ranking, Integer> drawResult(PurchasedLottos purchasedLottos, WinningNumbers winningNumbers) {
        return lottoMachine.draw(purchasedLottos, winningNumbers);
    }

    public double calculateEarningRate(PurchasedLottos purchasedLottos, EnumMap<Ranking, Integer> statistics) {
        return earningRateCalculator.calculateEarningRate(purchasedLottos, statistics);
    }
}
