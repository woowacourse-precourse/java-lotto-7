package lotto.domain;

public class LottoPurchaseAmount {

    private final int purchaseAmount;

    private LottoPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
    }

    public static LottoPurchaseAmount from(String amount) {
        return new LottoPurchaseAmount(amount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

}