package lotto.domain;

public class Budget {
    private final int budget;
    private final int lottoCount;

    public Budget(String budget) {
        validate(budget);
        this.budget = parseBudget(budget);
        this.lottoCount = this.budget / 1000;
    }

    private void validate(String budget) {
        if (budget == null || budget.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력해주세요.");
        }
        if (parseBudget(budget) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어져야 합니다!");
        }
        if (parseBudget(budget) <= 0) {
            throw new IllegalArgumentException("[ERROR] 1000원의 양의 배수인 금액을 입력해 주세요.");
        }
    }

    private int parseBudget(String budget) {
        try {
            return Integer.parseInt(budget);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 2,147,483,647원 이하 정수여야합니다.");
        }
    }

    public int getBudget() {
        return budget;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
