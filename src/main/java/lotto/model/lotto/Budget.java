package lotto.model.lotto;

import static lotto.exception.LottoErrorStatus.INVALID_BUDGET_UNIT;
import static lotto.model.constant.LottoRules.LOTTO_PRICE;

import lotto.exception.LottoException;

public class Budget {
    private final int budget;

    public Budget(int budget) {
        validateBudget(budget);
        this.budget = budget;
    }


    public int getBudget() {
        return budget;
    }

    public void validateBudget(int budget) {
        if (budget == 0 || budget % LOTTO_PRICE != 0) {
            throw new LottoException(INVALID_BUDGET_UNIT);
        }
    }
}
