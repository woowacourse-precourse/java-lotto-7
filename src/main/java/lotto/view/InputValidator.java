package lotto.view;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateIsEmpty(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력은 빈 값일 수 없습니다.");
        }
    }

    public static void validateIsNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자 형식이 아닙니다.");
        }
    }
}
