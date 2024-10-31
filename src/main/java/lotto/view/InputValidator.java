package lotto.view;

public class InputValidator {

    public static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 비어 있지 않아야 합니다.");
        }
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 정수여야 합니다.");
        }
    }

    public static void validateThousandUnit(int input) {
        if (input <= 0 || input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력값은 1,000원 단위의 정수여야 합니다.");
        }
    }
}
