package lotto.domain;

public class Budget {
    private final int budget;

    public Budget(int inputBudget) {
        budget = isValidBudget(inputBudget);
    }

    public int findLottoCounts() {
        return this.budget / 1000;
    }

    public double findRateOfReturn(int totalPrize) {
        double rateOfReturn = ((double) totalPrize / this.budget) * 100;
        return Math.round(rateOfReturn * 100) / 100.0;
    }

    private int isValidBudget(int budget) {
        isNonPositiveNumber(budget);
        canDividedByThousand(budget);
        return budget;
    }

    private void isNonPositiveNumber(int budget) {
        if (budget <= 0) {
            throw new IllegalArgumentException("양수를 입력하셔야 합니다.");
        }
    }

    private void canDividedByThousand(int budget) {
        if (budget % 1000 != 0) {
            throw new IllegalArgumentException("1,000원으로 나눠질 수 있는 금액을 입력하셔야 합니다.");
        }
    }
}
