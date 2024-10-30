package lotto.model;

public class Lottos {
    private long lottoPurchaseCount;

    public void calculateLottoPurchaseCount(String purchaseAmount) {
        long amount = Long.parseLong(purchaseAmount);
        lottoPurchaseCount = amount / 1000;
    }

    public long getLottoPurchaseCount() {
        return lottoPurchaseCount;
    }
}
