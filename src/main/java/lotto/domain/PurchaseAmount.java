package lotto.domain;

import static lotto.exception.ErrorMessage.*;
import static lotto.exception.ErrorMessage.INPUT_NOT_DIGIT;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public PurchaseAmount(String purchaseAmountInput) {
        validateNotBlank(purchaseAmountInput);
        validateDigit(purchaseAmountInput);

        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        validateMinimumPurchaseAmount(purchaseAmount);
        validateDivisibility(purchaseAmount);

        this.amount = purchaseAmount;
    }

    public int calculatePurchasableLottoCount() {
        return amount / LOTTO_PRICE;
    }

    private void validateNotBlank(String purchaseAmountInput) {
        if (purchaseAmountInput.isBlank()) {
            throw new IllegalArgumentException(INPUT_BLANK.getMessage());
        }
    }

    private void validateDigit(String purchaseAmountInput) {
        if (containsNonDigit(purchaseAmountInput)) {
            throw new IllegalArgumentException(INPUT_NOT_DIGIT.getMessage());
        }
    }

    private boolean containsNonDigit(String purchaseAmountInput) {
        return purchaseAmountInput.chars().anyMatch(character -> !Character.isDigit(character));
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
