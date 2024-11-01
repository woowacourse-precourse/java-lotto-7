package lotto;

public class Budget {
    private static final long LOTTO_PRICE = 1000;

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
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.BUDGET_NEGATIVE_NUMBER.message());
        }
    }

    private static void validateBudgetUnit(Long amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.BUDGET_INVALID_UNIT.message());
        }
    }

    public Long getAmount() {
        return amount;
    }


}
