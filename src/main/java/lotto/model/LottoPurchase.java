package lotto.model;

public class LottoPurchase {
    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;

    public LottoPurchase(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int lottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }
}