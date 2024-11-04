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
        } catch (ClassCastException ce) {
            // 이런 부분을 sout 으로 에러 출력하고 예외 던지기로 바꾸는것 정도만 고려
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력해야 합니다.");
        }

        return budgetNumber;
    }

    private static void checkValidateBudget(double budgetNumber, String budget) {
        if(budgetNumber != Integer.parseInt(budget)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000 원 단위의 정수만 입력해야 합니다.");
        }

        budgetNumber = Integer.parseInt(budget);
        if(budgetNumber < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1000 원 입니다.");
        }

        if(budgetNumber % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000 원 단위로만 가능합니다.");
        }
    }

}
