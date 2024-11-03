package lotto.validation;

public class Validator {
    public static final int ZERO = 0;
    public static void validateMultiplier(int dividend, int divisor) {
        if (dividend < divisor || dividend % divisor != ZERO) {
            System.out.printf("[ERROR] 입력 값은 %d단위여야 합니다.", divisor);
            throw new IllegalArgumentException();
        }
    }

    public static void validateEmptyInput(String input) {
        if (input.isBlank()) {
            System.out.println("[ERROR] 입력 값이 공백 혹은 빈 문자열입니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 값이 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateNegativeNumber(int number) {
        if (number < 0) {
            System.out.println("[ERROR] 입력 값이 음수이면 안됩니다.");
            throw new IllegalArgumentException();
        }
    }
}
