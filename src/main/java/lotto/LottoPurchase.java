package lotto;

import lotto.enums.ErrorMessage;

public class LottoPurchase {
    private final static int LOTTO_PRICE = 1000;
    private final static int ZERO = 0;
    final long purchaseAmount;

    public LottoPurchase(String purchaseAmount) {
        this.purchaseAmount = validate(purchaseAmount);
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    public long getPurchasedLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    private long validate(String inputAmount) {
        long amount;
        try {
            amount = Long.parseLong(inputAmount);
            validatePurchaseAmount(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getText());
        }
        return amount;
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_PURCHASE_UNIT.getText());
        } else if (purchaseAmount < ZERO) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_AMOUNT.getText());
        }
    }
}
