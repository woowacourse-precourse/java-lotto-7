package lotto.validator;

import lotto.constant.ErrorMessage;

public class PurchaseAmountValidator implements Validator {
    private static final Long limitAmount = 4611686000L;
    private final Long amount;

    public PurchaseAmountValidator(Long amount) {
        this.amount = amount;
    }

    @Override
    public void validate() {
        validateAmountIsNegative();
        validateAmountMultipleOfThousand();
        validateAmountGreaterThanLimit();
    }

    private void validateAmountIsNegative() throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_NEGATIVE.get());
        }
    }

    private void validateAmountMultipleOfThousand() throws IllegalArgumentException {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_NOT_MULTIPLE_OF_THOUSAND.get());
        }
    }

    private void validateAmountGreaterThanLimit() throws IllegalArgumentException {
        if (amount > limitAmount) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_OVER_LIMIT.get());
        }
    }
}
