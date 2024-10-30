package lotto;

public class Budget {

    private static final String BUDGET_NOT_NATURAL_NUMBER = "[ERROR] 구입 금액이 자연수가 아닙니다.";
    private static final String BUDGET_NOT_DIVIDED_ONE_THOUSAND = "[ERROR] 구입 금액이 1000원으로 나누어 떨어지지 않습니다.";

    private final int amount;

    public Budget(String inputBudget) {
        validateBudget(inputBudget);
        this.amount = Integer.parseInt(inputBudget);
    }

    private void validateBudget(String inputBudget) {
        try {
            int amount = Integer.parseInt(inputBudget);
            if (amount < 1) {
                throw new IllegalArgumentException(BUDGET_NOT_NATURAL_NUMBER);
            }
            checkDividedByOneThousand(amount);
        } catch (NumberFormatException e) {
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
