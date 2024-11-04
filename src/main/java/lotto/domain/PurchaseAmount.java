package lotto.domain;

import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_NOT_DIVISIBLE;
import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_NOT_ENOUGH;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int calculatePurchasableLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public double calculateProfitRate(int totalProfit) {
        return ((double) totalProfit / amount) * 100;
    }

    private void validate(int purchaseAmount) {
        validateMinimumPurchaseAmount(purchaseAmount);
        validateDivisibility(purchaseAmount);
    }

    private void validateMinimumPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_ENOUGH.getMessage());
        }
    }

    private void validateDivisibility(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_DIVISIBLE.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }
}
