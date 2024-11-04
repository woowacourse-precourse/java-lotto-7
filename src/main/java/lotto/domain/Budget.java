package lotto.domain;

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
            throw new IllegalArgumentException("[ERROR] 금액을 입력해주세요.");
        }
        if (parse(budget) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어져야 합니다!");
        }
        if (parse(budget) <= 0) {
            throw new IllegalArgumentException("[ERROR] 1000원의 양의 배수인 금액을 입력해 주세요.");
        }
    }

    public int getBudget() {
        return budget;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
