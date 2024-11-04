package lotto.domain;

import java.util.List;

public class LottoBuyer {
    // 구매 개수
    private int lottoPurchaseAmount;
    // 구매자의 총 수익률
    private int lotteryYield;

    public LottoBuyer(final int lottoPurchaseAmount) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
        this.lotteryYield = 0;
    }

    public int calculateLotteryYield(final int purchaseAmount, final int totalWinningAmount) {
        this.lotteryYield = totalWinningAmount / purchaseAmount * 100;
        return lotteryYield;
    }
}
