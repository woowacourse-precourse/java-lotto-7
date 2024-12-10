package lotto.model;

import lotto.common.ErrorMessage;

public class Budget {
    private static final long LOTTO_PRICE = 1000L;
    private static final long MIN_AMOUNT = 0L;
    private static final long ZERO = 0L;

    private final Long amount;

    private Budget(Long amount) {
        this.amount = amount;
    }

    public static Budget of(Long amount) {
        validate(amount);
        return new Budget(amount);
    }


    private static void validate(Long budget) {
        validateBudgetSign(budget);
        validateBudgetUnit(budget);
    }

    private static void validateBudgetSign(Long amount) {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.BUDGET_NEGATIVE_NUMBER.message());
        }
    }

    private static void validateBudgetUnit(Long amount) {
        if (amount % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(ErrorMessage.BUDGET_INVALID_UNIT.message());
        }
    }

    public Long getAmount() {
        return amount;
    }


}
