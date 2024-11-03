package lotto.domain;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public PurchaseAmount(int amount) {
        this.amount = amount;
    }

    private void validateMinimumPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 금액은 0 이상이어야 합니다.");
        }
    }
}
