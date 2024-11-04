package lotto.domain;

import lotto.constants.ErrorMessage;

public class PurchaseAmount {
    private static final int UNIT_PRICE = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 2000000000;
    private final int amount;

    private PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static PurchaseAmount from(String input) {
        validateNumberFormat(input);
        long amount = Long.parseLong(input);
        if (amount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE.getMessage());
        }
        return new PurchaseAmount((int) amount);

    }

    private static void validateNumberFormat(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private void validate(int amount) {
        validatePositiveAmount(amount);
        validateThousandUnit(amount);
    }

    private void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_ZERO.getMessage());
        }
    }

    private void validateThousandUnit(int amount) {
        if (amount % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getFormattedMessage(UNIT_PRICE));
        }
    }

    public int getAmount() {
        return amount;
    }
}
