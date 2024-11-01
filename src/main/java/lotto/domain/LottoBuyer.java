package lotto.domain;

import java.util.List;

public class LottoBuyer {

    private int lotteryYield;

    public LottoBuyer() {
        this.lotteryYield = 0;
    }

    public int calculateLotteryYield(final int purchaseAmount, final int totalWinningAmount) {
        this.lotteryYield = totalWinningAmount / purchaseAmount * 100;
        return lotteryYield;
    }
}
