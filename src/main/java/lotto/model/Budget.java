package lotto.model;

import lotto.exception.BudgetErrorMessage;

public class Budget {
    private static final Integer MIN_BUDGET = 1000;

    private Integer budget;

    public Budget(Integer budget) {
        validateBudget(budget);
        this.budget = budget;
    }

    public boolean buyLotto() {
        if (isUnavailable()) {
            return false;
        }
        budget -= Lotto.LOTTO_PRICE;
        return true;
    }

    private boolean isUnavailable() {
        return budget < Lotto.LOTTO_PRICE;
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
        if (budget % Lotto.LOTTO_PRICE == 0) {
            return;
        }

        throw new IllegalArgumentException(BudgetErrorMessage.BUDGET_UNIT_ERROR.getMessage());
    }
}
