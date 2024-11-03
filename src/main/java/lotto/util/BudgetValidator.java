package lotto.util;

public class BudgetValidator {
    private BudgetValidator() {
    }

    public static void validateInputBudget(String inputBudget) {
        validateNotEmpty(inputBudget);
        validateNumberFormat(inputBudget);
        validateIntegerFormat(inputBudget);
    }

    private static void validateNotEmpty(String inputBudget) {
        if (inputBudget == null || inputBudget.isEmpty()) {
            throw new IllegalArgumentException("사용자의 입력이 비었습니다.");
        }
    }

    private static void validateNumberFormat(String inputBudget) {
        if (!inputBudget.matches("\\d+")) {
            throw new IllegalArgumentException("구매 금액은 숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateIntegerFormat(String inputBudget) {
        try {
            Integer.parseInt(inputBudget);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 정수 형태여야 합니다.");
        }
    }
}
