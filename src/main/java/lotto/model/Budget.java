package lotto.model;

import lotto.exception.BudgetErrorMessage;

public class Budget {
    private static final Integer MIN_BUDGET = 1000;
    private static final Integer BUDGET_UNIT = 1000;

    private Integer budget;

    public Budget(Integer budget) {
        validateBudget(budget);
        this.budget = budget;
    }

    private void validateBudget(Integer budget) {
        validateBudgetRange(budget);
        validateBudgetUnit(budget);
    }

    private void validateBudgetRange(Integer budget) {
        if (budget < MIN_BUDGET) {
            throw new IllegalArgumentException(BudgetErrorMessage.BUDGET_RANGE_ERROR.getMessage());
        }
    }

    private void validateBudgetUnit(Integer budget) {
        if (budget % BUDGET_UNIT == 0) {
            return;
        }

        throw new IllegalArgumentException(BudgetErrorMessage.BUDGET_UNIT_ERROR.getMessage());
    }
}
