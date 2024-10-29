package lotto.converter;

import lotto.exception.ErrorCode;

public class PurchaseCountConverter {

    private static final String INTEGER_PATTERN = "\\d+";
    private static final int LOTTO_AMOUNT = 1000;
    private static final int ZERO = 0;

    public int getPurchaseCount(String inputPurchaseAmount) {
        if (!isPositiveInteger(inputPurchaseAmount)) {
            throw new IllegalArgumentException(ErrorCode.NOT_POSITIVE_INTEGER.getMessage());
        }
        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        if (!isDivisibleByThousand(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorCode.NOT_DIVISIBLE_BY_THOUSAND.getMessage());
        }
        return purchaseAmount / LOTTO_AMOUNT;
    }

    private boolean isPositiveInteger(String inputPurchaseAmount) {
        return inputPurchaseAmount.matches(INTEGER_PATTERN);
    }

    private boolean isDivisibleByThousand(int purchaseAmount) {
        return purchaseAmount % LOTTO_AMOUNT == ZERO;
    }
}
