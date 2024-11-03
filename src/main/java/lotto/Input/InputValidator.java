package lotto.Input;

public class InputValidator {
    public int validateInput(String input) {
        validateNumberFormat(input);
        try {
            int amount = Integer.parseInt(input);
            validatePositiveAmount(amount);
            validateThousandUnit(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 너무 큽니다.");
        }
    }

    private void validateNumberFormat(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
    }

    private void validateThousandUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
