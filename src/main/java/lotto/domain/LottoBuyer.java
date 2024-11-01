package lotto.domain;

import java.util.List;

public class LottoBuyer {
    private int lottoPurchaseAmount;
    private int lotteryYield;

    public LottoBuyer(final int lottoPurchaseAmount) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
        this.lotteryYield = 0;
    }

    public void setLottoPurchaseAmount(final int lottoPurchaseAmount) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    public int calculateLotteryYield(final int purchaseAmount, final int totalWinningAmount) {
        this.lotteryYield = totalWinningAmount / purchaseAmount * 100;
        return lotteryYield;
    }
}
