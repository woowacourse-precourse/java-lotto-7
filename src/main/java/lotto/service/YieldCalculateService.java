package lotto.service;

import lotto.domain.Wallet;
import lotto.domain.calculators.YieldCalculator;
import lotto.domain.lottos.user.WinningRank;

public class YieldCalculateService {
    private final YieldCalculator yieldCalculator;
    private final Wallet wallet;
    private final WinningRank winningRank;

    public YieldCalculateService(YieldCalculator yieldCalculator, Wallet wallet, WinningRank winningRank) {
        this.yieldCalculator = yieldCalculator;
        this.wallet = wallet;
        this.winningRank = winningRank;
    }

    public void calculateRateOfReturn() {
        long prizeAmount = winningRank.calculateTotalPrizeAmount();
        wallet.calculateRateOfReturn(yieldCalculator, prizeAmount);
    }

}
