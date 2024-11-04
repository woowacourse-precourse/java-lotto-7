package validation;

public class BudgetValidator {
    private BudgetValidator() {}

    public static void validate(String budget) {
        double budgetNumber = checkTypeOfBudget(budget);
        checkValidateBudget(budgetNumber, budget);
    }

    private static double checkTypeOfBudget(String budget) {
        double budgetNumber;

        try {
            budgetNumber = Double.parseDouble(budget);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력해야 합니다.");
        }

        return budgetNumber;
    }

    private static void checkValidateBudget(double budgetNumber, String budget) {
        if(budgetNumber != Integer.parseInt(budget)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수만 입력해야 합니다.");
        }

        budgetNumber = Integer.parseInt(budget);
        if(budgetNumber < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000 원 이상이어야 합니다.");
        }

        if(budgetNumber % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000 원 단위여야 합니다.");
        }
    }

}
