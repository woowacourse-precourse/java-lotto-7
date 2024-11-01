package lotto;

public class Budget {
    private static final String ERROR_BUDGET_NEGATIVE_NUMBER = "[ERROR] 금액은 음수일 수 없습니다.";
    private static final String ERROR_BUDGET_INVALID_UNIT = "[ERROR] 금액은 1000원 단위여야 합니다.";
    private static final long LOTTO_PRICE = 1000;

    private Long amount;

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
            throw new IllegalArgumentException(ERROR_BUDGET_NEGATIVE_NUMBER);
        }
    }

    private static void validateBudgetUnit(Long amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_BUDGET_INVALID_UNIT);
        }
    }

    public Long getAmount() {
        return amount;
    }


}
