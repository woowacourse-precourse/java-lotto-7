package lotto.Input;

public class InputValidator {
    public int validateInput(String input) {
        try {
            int amount = Integer.parseInt(input);
            validatePositiveAmount(amount);
            validateThousandUnit(amount);
            return amount;
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 합니다.");
        }
    }

    private void validateThousandUnit(int amount) {
    }
}
