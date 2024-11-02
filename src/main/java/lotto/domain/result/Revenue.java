package lotto.domain.result;

import lotto.global.constant.LottoConstant;

public class Revenue {

    private static final int PERCENTAGE_MULTIPLIER = 100;

    private final int totalPrizeAmount;
    private final int totalPurchaseAmount;

    private Revenue(final int totalPrizeAmount, final int purchaseCount) {
        this.totalPrizeAmount = totalPrizeAmount;
        this.totalPurchaseAmount = calculateTotalPurchaseAmount(purchaseCount);
    }

    public static Revenue of(final int totalPrizeAmount, final int purchaseCount) {
        return new Revenue(totalPrizeAmount, purchaseCount);
    }

    private int calculateTotalPurchaseAmount(final int purchaseCount) {
        return purchaseCount * LottoConstant.LOTTO_PRICE;
    }

    public double calculateProfitRate() {
        return (double) totalPrizeAmount / totalPurchaseAmount * PERCENTAGE_MULTIPLIER;
    }
}
