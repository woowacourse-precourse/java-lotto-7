package lotto.view;

public class ValidatorOfView {

    static int MINIMUM_BUDGET_UNIT = 1000;
    public static void isValidBudget(int budget) {
        if (!isGreaterThanZero(budget)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 자연수여야 합니다.");
        }
        if (!isMultipleOfUnitPrice(budget)) {
            throw new IllegalArgumentException(String.format("[ERROR] 구매 금액은 %d의 배수여야 합니다.", MINIMUM_BUDGET_UNIT));
        }
    }

    public static boolean isGreaterThanZero(int budget) {
        return budget > 0;
    }

    public static boolean isMultipleOfUnitPrice(int money) {
        return money % MINIMUM_BUDGET_UNIT == 0;
    }

}
