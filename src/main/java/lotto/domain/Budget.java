package lotto.domain;

import static lotto.constant.ErrorMessage.BUDGET_NOT_DIVIDED_ONE_THOUSAND;
import static lotto.constant.ErrorMessage.BUDGET_NOT_NATURAL_NUMBER;

public class Budget {

    private final int amount;

    public Budget(String inputBudget) {
        validate(inputBudget);
        this.amount = Integer.parseInt(inputBudget);
    }

    private void validate(String inputBudget) {
        try {
            int amount = Integer.parseInt(inputBudget);
            checkNaturalNumber(amount);
            checkDividedByOneThousand(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BUDGET_NOT_NATURAL_NUMBER);
        }
    }

    private void checkNaturalNumber(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException(BUDGET_NOT_NATURAL_NUMBER);
        }
    }

    private void checkDividedByOneThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(BUDGET_NOT_DIVIDED_ONE_THOUSAND);
        }
    }

    public int getAmount() {
        return amount;
    }
}
