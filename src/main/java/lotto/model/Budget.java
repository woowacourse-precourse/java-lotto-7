package lotto.model;

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
        if (budget == 0 || budget % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 로또를 구매할 수 있습니다.");
        }
    }
}
