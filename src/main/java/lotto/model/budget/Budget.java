package lotto.model.budget;

import lotto.config.ErrorMessage;
import lotto.config.SystemConfig;
import lotto.exception.BudgetException;

public record Budget(int money) {
    private static final int cost = SystemConfig.LOTTO_COST;

    public Budget {
        validate(money);
    }

    public int getCount() {
        return money / cost;
    }

    private static void validate(int money) {
        if (money == 0 || (money % cost) > 0) {
            throw new BudgetException(ErrorMessage.BUDGET_UNIT);
        }
        if (money < 0) {
            throw new BudgetException(ErrorMessage.NEGATIVE_DIGIT);
        }
    }
}