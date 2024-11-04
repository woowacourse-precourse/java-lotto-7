package lotto.model;

import static lotto.enums.ErrorCode.PURCHASE_AMOUNT_BELOW_MINIMUM;
import static lotto.enums.ErrorCode.PURCHASE_AMOUNT_MUST_BE_NUMBER;
import static lotto.enums.ErrorCode.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final long amount;

    public Money(String purchaseAmountInput) {
        validatePurchaseAmount(purchaseAmountInput);
        this.amount = Long.parseLong(purchaseAmountInput);
    }

    private void validatePurchaseAmount(String purchaseAmountInput) {
        checkIsNumber(purchaseAmountInput);
        long purchaseAmount = Long.parseLong(purchaseAmountInput);
        checkMinimumAmount(purchaseAmount);
        checkUnit(purchaseAmount);
    }

    private void checkIsNumber(String purchaseAmount) {
        try {
            Long.parseLong(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_MUST_BE_NUMBER.getMessage());
        }
    }

    private void checkMinimumAmount(long purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_BELOW_MINIMUM.getMessage());
        }
    }

    private void checkUnit(long purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getMessage());
        }
    }

    public long getAmount() {
        return amount;
    }

    public int getNumberOfLottos() {
        return (int) (amount / LOTTO_PRICE);
    }
}
