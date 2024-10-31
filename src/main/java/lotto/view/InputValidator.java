package lotto.view;

public class InputValidator {

    public static void validatePurchaseAmount(String input) {
        InputValidator.validateNotBlank(input);
        InputValidator.validateInteger(input);
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 비어 있지 않아야 합니다.");
        }
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 정수여야 합니다.");
        }
    }
}
