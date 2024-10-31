package lotto.domain;

import lotto.common.ErrorMessages;

public class PurchaseAmount {
    private static final int UNIT = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100000;
    private static final int PERCENTAGE_CONVERSION_FACTOR = 100;
    private final int amount;

    public PurchaseAmount(String input) {
        this.amount = parseAndValidate(input);
    }

    private int parseAndValidate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessages.NULL_PURCHASE_AMOUNT);
        }
        try {
            int amount = Integer.parseInt(input);
            if (amount <= 0 || amount % UNIT != 0) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT_UNIT);
            }
            if (amount > MAX_PURCHASE_AMOUNT) {
                throw new IllegalArgumentException(ErrorMessages.EXCEEDED_PURCHASE_AMOUNT);
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT_INPUT_ERROR);
        }
    }

    public int getTicketCount() {
        return amount / UNIT;
    }

    public double calculateYield(int totalPrize) {
        return (double) totalPrize / amount * PERCENTAGE_CONVERSION_FACTOR;
    }
}
