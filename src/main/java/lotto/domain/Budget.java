package lotto.domain;

import static lotto.constant.ErrorMessage.INVALID_BUDGET;
import static lotto.constant.ErrorMessage.NOT_INPUT_BUDGET;
import static lotto.util.IntegerConvertor.parse;

public class Budget {
    private final int budget;
    private final int lottoCount;

    public Budget(String budget) {
        validate(budget);
        this.budget = parse(budget);
        this.lottoCount = this.budget / 1000;
    }

    private void validate(String budget) {
        if (budget == null || budget.isEmpty()) {
            throw new IllegalArgumentException(NOT_INPUT_BUDGET.getMessage());
        }
        if (parse(budget) % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_BUDGET.getMessage());
        }
        if (parse(budget) <= 0) {
            throw new IllegalArgumentException(INVALID_BUDGET.getMessage());
        }
    }

    public int getBudget() {
        return budget;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
