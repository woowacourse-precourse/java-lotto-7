package lotto.vo;

import lotto.constant.ErrorMessage;
import lotto.domain.LottoPublisher;

public record PurchaseAmount(int value) {
    public PurchaseAmount(String input) {
        this(validatePurchaseAmount(input));
    }

    private static int validatePurchaseAmount(String input) {
        int purchaseAmount = parseInt(input);
        validatePositive(purchaseAmount);
        validateAmount(purchaseAmount);
        return purchaseAmount;
    }

    private static void validatePositive(int purchaseAmount) {
        if (!isPositive(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_ERROR);
        }
    }

    private static void validateAmount(int purchaseAmount) {
        if (isPurchasableLottoAmount(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT_ERROR);
        }
    }

    private static boolean isPositive(int purchaseAmount) {
        return purchaseAmount > 0;
    }

    private static boolean isPurchasableLottoAmount(int purchaseAmount) {
        return purchaseAmount % LottoPublisher.LOTTO_PRICE != 0;
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }
}