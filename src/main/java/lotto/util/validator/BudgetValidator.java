package lotto.util.validator;

import static lotto.util.Constants.LOTTO_PRICE;
import lotto.util.ExceptionMessage;

public class BudgetValidator extends AbstractValidator<Integer> {
    private static final int MIN_BUDGET = 1_000;
    private static final int MAX_BUDGET = 100_000;

    @Override
    protected Integer convertAndValidate(String input) {
        int budgetValue = Integer.parseInt(input);
        validateInputRange(budgetValue);
        validateInputUnit(budgetValue);
        return budgetValue;
    }

    private void validateInputRange(int budgetValue) {
        if (budgetValue < MIN_BUDGET || budgetValue > MAX_BUDGET) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_OUT_OF_BUDGET_RANGE.getMessage());
        }
    }

    private void validateInputUnit(int budgetValue) {
        if (budgetValue % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_UNIT_OF_BUDGET.getMessage());
        }
    }
}