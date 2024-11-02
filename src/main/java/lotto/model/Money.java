package lotto.model;

import lotto.controller.error.ErrorType;

public class Money {

    public static final int UNIT_AMOUNT = 1000;

    private final int amount;

    public Money(final int amount) {
        validateNonNegative(amount);
        validateUnitAmount(amount);
        this.amount = amount;
    }

    public static Money fromString(final String amount) {
        return new Money(parseAmount(amount));
    }

    public static Money fromLottoCount(final int lottoCount) {
        final int totalAmount = lottoCount * UNIT_AMOUNT;
        return new Money(totalAmount);
    }

    private static int parseAmount(final String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_FORMAT.getMessage(), e);
        }
    }

    private void validateNonNegative(final int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorType.NEGATIVE_AMOUNT.getMessage());
        }
    }

    private void validateUnitAmount(final int amount) {
        if (amount % UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException(ErrorType.INVALID_UNIT_AMOUNT.getMessage());
        }
    }

    public int calculateLottoCount() {
        return amount / UNIT_AMOUNT;
    }

    public int getAmount() {
        return amount;
    }
}
