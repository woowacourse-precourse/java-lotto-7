package lotto.service;

import lotto.domain.Wallet;
import lotto.domain.calculators.YieldCalculator;
import lotto.domain.lottos.user.WinningLotto;

public class YieldCalculateService {
    private final YieldCalculator yieldCalculator;
    private final Wallet wallet;
    private final WinningLotto winningLotto;

    public YieldCalculateService(YieldCalculator yieldCalculator, Wallet wallet, WinningLotto winningLotto) {
        this.yieldCalculator = yieldCalculator;
        this.wallet = wallet;
        this.winningLotto = winningLotto;
    }

    public void calculateRateOfReturn() {
        long prizeAmount = winningLotto.calculateTotalPrizeAmount();
        wallet.calculateRateOfReturn(yieldCalculator, prizeAmount);
    }

}
