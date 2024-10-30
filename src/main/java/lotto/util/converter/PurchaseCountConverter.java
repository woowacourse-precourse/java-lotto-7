package lotto.util.converter;

import lotto.exception.ErrorCode;

public class PurchaseCountConverter {

    private static final String INTEGER_PATTERN = "\\d+";
    private static final int LOTTO_AMOUNT = 1000;
    private static final int ZERO = 0;

    private final int purchaseAmount;

    public PurchaseCountConverter(String inputPurchaseAmount) {
        validate(inputPurchaseAmount);
        this.purchaseAmount = Integer.parseInt(inputPurchaseAmount);
    }

    public int convert() {
        if (!isDivisibleByThousand(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorCode.NOT_DIVISIBLE_BY_THOUSAND.getMessage());
        }
        return purchaseAmount / LOTTO_AMOUNT;
    }

    private void validate(String inputPurchaseAmount) {
        if (!isPositiveInteger(inputPurchaseAmount)) {
            throw new IllegalArgumentException(ErrorCode.NOT_POSITIVE_INTEGER.getMessage());
        }
    }

    private boolean isPositiveInteger(String inputPurchaseAmount) {
        return inputPurchaseAmount.matches(INTEGER_PATTERN);
    }

    private boolean isDivisibleByThousand(int purchaseAmount) {
        return purchaseAmount % LOTTO_AMOUNT == ZERO;
    }
}
